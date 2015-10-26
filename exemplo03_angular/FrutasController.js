angular.module("frutasApp", ["ngAnimate"])
       .controller("FrutasController", function () {
            var self = this;
            self.busca = "";
            self.frutas = [];
            self.frutas_removidas = [];

            self.add = function (ev) {
                if (ev.keyCode === 13) {
                    self.frutas.push({nome: self.busca, hidden: false});
                    self.busca = "";
                    self.frutas.sort(function (a, b) {
                        if (a.nome < b.nome) {
                            return -1
                        } else {
                            return 1;
                        }
                    });
                }
            };

            self.search = function () {
                for (var i = 0; i < self.frutas.length; i++) {
                    if (self.frutas[i].nome.search(self.busca) !== 0) {
                        self.frutas[i].hidden = "hidden";
                    } else {
                        self.frutas[i].hidden = "";
                    }
                };
            };

            self.remove = function (target) {
                for (var i = 0; i < self.frutas.length; i++) {
                    if (self.frutas[i] === target) {
                        self.frutas.splice(i, 1);
                        return;
                    }
                };
            };

            self.editar = function (target) {
                self.remove(target);
                self.busca = target.nome;
            };

});
