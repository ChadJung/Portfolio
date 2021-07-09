# Portfolio Web Project [![Build Status](https://travis-ci.com/ChadJung/Portfolio.svg?branch=master)](https://travis-ci.com/ChadJung/Portfolio)

- Java
- thymeleaves html
- javascript(bootstrap, jquery)
- bootstrap css
- yaml configurations(CI/CD)

# 개요

- 간단한 Rest API 구현
- Amazon RDS 데이터베이스 사용
- Amazon EC2 인스턴스를 통한 가상 웹 서버
- Travis CI 와 쉘 스크립트, nginx를 이용한 CD/CI 

# 상세

- Master branch에 Push 발생 시 Travis CI에서 빌드
- .travis.yml 설정과 AWS IAM에서 Codedeploy 역할 할당을 통해 배포 스크립트 실행

  ![image](https://user-images.githubusercontent.com/43230970/124695924-1ab54680-df1f-11eb-9afa-5ad6d5fbc08d.png)
  
- EC2 인스턴스 내 쉘 스크립트를 통한 배포와 2개의 인스턴스를 운영하여 nginx를 이용한 무중단 배포

  ![image](https://user-images.githubusercontent.com/43230970/124696731-906de200-df20-11eb-86ec-40d687b501ad.png)

  
