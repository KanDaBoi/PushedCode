"use strict";
exports.__esModule = true;
var EmployeeTest = /** @class */ (function () {
    function EmployeeTest(employee) {
        this.employee = employee;
    }
    EmployeeTest.prototype.display = function () {
        console.log("id:" + this.employee.id);
        console.log("name:" + this.employee.name);
        console.log("salary:" + this.employee.salary);
        console.log("permanent:" + this.employee.permanent);
        console.log("department id:" + this.employee.department.id);
        console.log("department name:" + this.employee.department.name);
        var iterator;
        var counter = 0;
        for (var _i = 0, _a = this.employee.skills; _i < _a.length; _i++) {
            iterator = _a[_i];
            console.log("Skill[" + counter + "]:" + iterator.id + ", " + iterator.name);
            counter = counter + 1;
        }
    };
    return EmployeeTest;
}());
var employee = { id: 1, name: "Kanishk Jha", salary: 25000, permanent: true, department: { id: 1, name: "CSE" }, skills: [{ id: 1, name: "C" }, { id: 2, name: "Java" }, { id: 3, name: "Python" }] };
var employeeTest = new EmployeeTest(employee);
employeeTest.display();
