var Greeter = /** @class */ (function () {
    function Greeter(message) {
        this.greeting = message;
    }
    Greeter.prototype.greet = function () {
        return "Hello" + this.greeting;
    };
    return Greeter;
}());
var greeter = new Greeter("world");
/** document.write(`<p> ${greeter.greet()} </p>`); */
document.getElementById("greeting").innerHTML = greeter.greet();
