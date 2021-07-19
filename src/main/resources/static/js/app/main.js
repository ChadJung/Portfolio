$(function()
{
    if(location.pathname === "/") {
        $('#nav-home').addClass('active');
    }

    if(location.href.indexOf("members") > -1) {
        $('#nav-members').addClass('active');
    }

    if(location.href.indexOf("items") > -1) {
        $('#nav-items').addClass('active');
    }

    if(location.href.indexOf("orders") > -1) {
        $('#nav-orders').addClass('active');
    }

    if(location.href.indexOf("posts") > -1) {
        $('#nav-posts').addClass('active');
    }
});