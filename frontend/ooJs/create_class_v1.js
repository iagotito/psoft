function create_class (subject, vacancies) {
    let c = {};
    c.subject = subject;
    c.vacancies = vacancies;
    c.students = [];
    c.register = function (student) {
        if (vacancies == 0) {
            return false;
        } else {
            vacancies -= 1;
            c.students.push(student);
            return true;
        }
    }
    c.getStudents = function () {
        return c.students.toString();
    }
    c.getVacancies = function () {
        return c.vacancies.toString();
    }
    return c;
}

c = create_class("LOAC", "2");

console.log(c.register("Iago1"));
console.log(c.register("Iago2"));
console.log(c.register("Iago3"));
console.log("\n\n");

console.log(c.getStudents().toString());
console.log("\n\n");

console.log(c.getVacancies());
