exports.disciplina = disciplina;
exports.turma = turma;
exports.estudante = estudante;
exports.professor = professor;

function disciplina (id, nome, creditos, pre_requisitos) {
    let _id = id;
    let _nome = nome;
    let _creditos = creditos;
    let _pre_requisitos = pre_requisitos;

    let dis = {};
    dis.id = () => _id;
    dis.get_nome = () => _nome;
    dis.set_nome = function (novo_nome) {
        _nome = novo_nome;
    }
    dis.creditos = _creditos;
    dis.pre_requisitos = _pre_requisitos;

    return dis;
}

function turma (disciplina, periodo) {
    let _disciplina = disciplina;
    let _periodo = periodo;
    let _professor = null;
    let _estudantes = [];
    let _status = 'planejada';

    let tur = {};

    tur.get_disciplina = () => _disciplina;
    tur.get_periodo = () => _periodo;

    tur.set_professor = novo_professor => {
        _professor = novo_professor;
    }
    tur.get_professor = () => _professor;

    tur.matricula = (e) => {
        if (novo === 'planejada' || novo === 'ativa') {
            if (_estudantes.filter(a => a._matricula === e._matricula).length === 0) {
            _estudantes.push(e)
            e.adiciona_turma(tur)
            }
        }

    };

    tur.set_status = (novo) => {
        if (novo === 'planejada' || novo === 'ativa' || novo === 'concluida')
            _status = novo;
    }

    return tur;
}

function professor (matricula, nome, email, cpf, url) {
    let _matricula = matricula;
    let _nome = nome;
    let _email = email;
    let _cpf = cpf;
    let _url = url;
    let _turmas = [];

    let prof = {};
    return prof;
}

function estudante (matricula, nome, email, cpf, url) {
    let _matricula = matricula;
    let _nome = nome;
    let _email = email;
    let _cpf = cpf;
    let _url = url;
    let _turmas = [];

    est = {};

    est.matricula_aluno = (t) => t.matricula(est);
    est.adiciona_turma = (t) => _turmas.push(t);

    return est;
}
