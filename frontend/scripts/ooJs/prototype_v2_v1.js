let proto_person = {
    speak: function () {
        return "hi, I am " + this.name;
    }
};
function create_person(name) {
    let person = Object.create(proto_person);
    person.name = name;
    return person;
}
let p1 = create_person("Iago");
// let p2 = create_person();
// let p3 = create_person();

console.log(p1.speak());

console.log(p1.speak == p2.speak);
console.log(p1.speak == p3.speak);
console.log(p2.speak == p3.speak);