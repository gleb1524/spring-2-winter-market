angular.module('app', ['ngStorage']).controller('indexController', function ($scope, $http, $localStorage) {
    $scope.tryToAuth = function () {
        $http.post('http://localhost:8180/winter/auth', $scope.user)
            .then(function successCallback(response){
                if(response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.winterMarketUser = {username: $scope.user.username, token: response.data.token};

                    $scope.user.username = null;
                    $scope.user.password = null;

                    // $http.get('http://localhost:8180/winter/api/v1/cart' + $localStorage.springWebGuestCartId + '/merge')
                    //     .then(function successCallback(response){
                    //     });
                    //
                    // location.path('/');
                }
            }, function errorCallback(response){
            });
    };

    $scope.tryToLogout = function () {
        $scope.clearUser();
        $scope.user = null;
        // $location.path('/');
    };

    $scope.clearUser = function () {
        delete $localStorage.winterMarketUser;
        $http.defaults.headers.common.Authorization = '';
    };

    $scope.isUserLoggedIn = function () {
        if($localStorage.winterMarketUser) {
            return true;
        }else {
            return false;
        }
    };

    if ($localStorage.winterMarketUser) {
        try {
            let jwt = $localStorage.winterMarketUser.token;
            let payload = JSON.parse(atob(jwt.split('.')[1]));
            let currentTime = parseInt(new Date().getTime() / 1000);
            if (currentTime > payload.exp) {
                console.log("Token is expired!!!");
                delete $localStorage.winterMarketUser;
                $http.defaults.headers.common.Authorization = '';
            }
        } catch (e) {
        }

        $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.winterMarketUser.token;
    }

    $scope.placedOrder = function (){
        $http.post('http://localhost:8180/winter/api/v1/orders').then(function (response) {
            $scope.clearCart();
        });
    }

    $scope.getOrders = function (){
        $http.get('http://localhost:8180/winter/api/v1/orders').then(function (response) {
            alert(response.data.id);
        });
    }

    $scope.loadProducts = function () {
        $http.get('http://localhost:8180/winter/api/v1/products').then(function (response) {
            $scope.productsList = response.data;
        });
    }

    $scope.loadCart = function () {
        $http.get('http://localhost:8190/winter-carts/api/v1/cart').then(function (cartResponse) {
            $scope.cart = cartResponse.data;
        });
    }


    $scope.putProductInCart = function (productId) {
        $http.get('http://localhost:8190/winter-carts/api/v1/cart/add/' + productId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.deleteProductFromCartById = function (productId) {
        $http.delete('http://localhost:8190/winter-carts/api/v1/cart' + productId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.clearCart = function () {
        $http.delete('http://localhost:8190/winter-carts/api/v1/cart').then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.deleteItem = function (itemId) {
        $http.delete('http://localhost:8190/winter-carts/api/v1/cart/items/' + itemId).then(function (response) {
            $scope.loadCart();
        });
    }



    $scope.loadProducts();
    $scope.loadCart();

});