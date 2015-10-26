angular.module("frutasApp", ["ngAnimate"])
       .controller("FrutasController", function () {
            var self = this;
            self.busca = "";
            self.frutas = [];

            self.add = function (ev) {
                if (ev.keyCode === 13) {
                    self.frutas.push(self.busca);
                    self.busca = "";
                }
            };

});
