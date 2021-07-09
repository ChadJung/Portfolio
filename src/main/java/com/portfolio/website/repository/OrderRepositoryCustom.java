package com.portfolio.website.repository;

import com.portfolio.website.domain.Order;
import com.portfolio.website.domain.OrderStatus;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import static com.portfolio.website.domain.QMember.*;
import static com.portfolio.website.domain.QOrder.*;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryCustom {

    private final EntityManager em;

    public List<Order> searchAllByUsername(OrderSearch orderSearch) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        return query.select(order)
                .from(order)
                .join(order.member, member)
                .where(statusEq(orderSearch.getOrderStatus()), nameLike(orderSearch.getMemberName()))
                .limit(1000)
                .fetch();
    }

    private BooleanExpression nameLike(String memberName) {
        if (!StringUtils.hasText(memberName))
            return null;
        return member.name.like(memberName);
    }

    private BooleanExpression statusEq(OrderStatus statusCond) {
        if (statusCond == null) {
            return null;
        }

        return order.status.eq(statusCond);
    }
}
