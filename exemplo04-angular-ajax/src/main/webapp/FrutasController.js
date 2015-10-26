angular.module("frutasApp", ["ngAnimate"])
       .controller("FrutasController", ["$http", function ($http) {
            var self = this;
            self.busca = "";
            self.frutas = [];
            self.frutas_removidas = [];

            self.add = function (ev) {
                if (ev.keyCode === 13) {
                    $http.post("fruta", "nome=" + self.busca, {
                       headers: {
                           "Content-Type": "application/x-www-form-urlencoded"
                       }
                    }).then(function (data) {
                        self.frutas.push({ nome: self.busca, hidden: ""});
                        self.busca = "";
                    });
                }
            };

}]);
