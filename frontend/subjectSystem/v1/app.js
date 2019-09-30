window.subjects;
let $message = document.querySelector("#message");
let $subjects = document.querySelector("#subjectsDiv");
let $subjectName = document.querySelector("#subjectName");
let $subjectGrade = document.querySelector("#subjectGrade");
let $saveButton = document.querySelector("#saveButton");

//$saveButton.addEventListener("click", function () {
 //   save();
//})

function handler (data) {
    console.log("inicando execução do handler dos dados");
    $subjects.innerHTML = "";
    window.subjects = data;
    window.subjects.forEach((e, i) => {
        let $p = document.createElement("p");
        $subjects.appendChild($p);
        $p.innerText = "Subject: " + window.subjects[i].name + "\nGrade: " + window.subjects[i].grade;
    })
}

fetch("subjects.json")
.then(response => response.json())
.then(data => handler(data))