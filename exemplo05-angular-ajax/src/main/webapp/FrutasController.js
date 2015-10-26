angular.module("frutasApp", ["ngAnimate"])
       .controller("FrutasController", ["$http", function ($http) {
            var self = this;
            self.busca = "";
            self.frutas = [];
            self.frutas_removidas = [];

            $http.get("fruta", { params: { busca: self.busca} })
                 .then(function (response) {
                     self.frutas = response.data;
                 });

            self.add = function (ev) {
                if (ev.keyCode === 13) {
                    $http.post("fruta", "nome=" + self.busca + "&method=adicionar", {
                       headers: {
                           "Content-Type": "application/x-www-form-urlencoded"
                       }
                    }).then(function (response) {
                        self.frutas.push({ nome: self.busca, hidden: ""});
                        self.busca = "";
                    });
                }
            };

            self.search = function () {
                $http.get("fruta", { params: { busca: self.busca} })
                     .then(function (response) {
                         self.frutas = response.data;
                     });
            };

            self.remove = function (target) {
                $http.post("fruta", "id=" + target.id + "&method=deletar", {
                   headers: {
                       "Content-Type": "application/x-www-form-urlencoded"
                   }
                }).then(function (response) {
                    for (var i = 0; i < self.frutas.length; i++) {
                        if (self.frutas[i] === target) {
                            self.frutas.splice(i, 1);
                            return;
                        }
                    };
                });
            };

            self.editar = function (target) {
                self.remove(target);
                self.busca = target.nome;
            };

}]);
