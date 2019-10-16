exports.disciplina = disciplina;
exports.turma = turma;

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

function turma (id_dis, periodo) {
    let professor = null;
    estudantes = [];
    // TODO
}
