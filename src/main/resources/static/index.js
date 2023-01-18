angular.module('app', []).controller('indexController', function ($scope, $http) {
    $scope.loadProducts = function () {
        $http.get('http://localhost:8180/winter/api/v1/products').then(function (response) {
            $scope.productsList = response.data;
        });
    }
    $scope.loadCart = function () {
        $http.get('http://localhost:8180/winter/api/v1/cart').then(function (cartResponse) {
            $scope.cart = cartResponse.data;
        });
    }


    $scope.putProductInCart = function (productId) {
        $http.get('http://localhost:8180/winter/api/v1/cart/add/' + productId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.deleteProductFromCartById = function (cartId) {
        $http.delete('http://localhost:8180/winter/api/v1/cart/' + cartId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.loadProducts();
    $scope.loadCart();

});