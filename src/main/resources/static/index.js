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

    $scope.deleteProductFromCartById = function (productId) {
        $http.delete('http://localhost:8180/winter/api/v1/cart/' + productId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.clearCart = function () {
        $http.delete('http://localhost:8180/winter/api/v1/cart').then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.deleteItem = function (itemId) {
        $http.delete('http://localhost:8180/winter/api/v1/cart/items/' + itemId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.loadProducts();
    $scope.loadCart();

});