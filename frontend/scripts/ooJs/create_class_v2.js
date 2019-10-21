function create_class (subject, vacancies) {
    return {
        subject : subject,
        vacancies : vacancies,
        students : [],
        register : function (student) {
            if (vacancies == 0) {
                return false;
            } else {
                vacancies -= 1;
                this.students.push(student);
                return true;
            }
        },
        getStudents : function () { return this.students.toString() },
        getVacancies : function () { return this.vacancies.toString() }
    };
}

c = create_class("LOAC", "2");

console.log(c.register("Iago1"));
console.log(c.register("Iago2"));
console.log(c.register("Iago3"));
console.log("\n\n");

console.log(c.getStudents().toString());
console.log("\n\n");

console.log(c.getVacancies());
