let assert = require('assert');
let disciplina = require('./scoord').disciplina;
let turma = require('./scoord').turma;
let estudante = require('./scoord').estudante;
let professor = require('./scoord').professor;

describe('factory Disciplina', function() {
  let d0;

    before(async () => {
        d0 = disciplina('prog1', 'Programação 1', 4, []);
    })

    it('deve criar disciplinas distintas a cada invocação', function(){
        d0 = disciplina('prog1', 'Programação 1', 4, []);
        d1 = disciplina('prog1', 'Programação 1', 4, []);
        d2 = disciplina('prog1', 'Programação 1', 4, []);
        assert.notEqual(d0, d1);
        assert.notEqual(d0, d2);
        assert.notEqual(d1, d2);
    });

    it('deve reter os dados de inicialização', function(){
        assert.equal('prog1', d0.id());
        assert.equal('Programação 1', d0.get_nome());
        assert.equal(4, d0.creditos);
        assert.deepEqual([], d0.pre_requisitos);
    });

    it('deve permitir atualização de nome', function(){
        d0.set_nome('Programação de Computadores I')
        assert.equal('prog1', d0.id());
        assert.equal('Programação de Computadores I', d0.get_nome());
        assert.deepEqual([], d0.pre_requisitos);
    });

    it('não deve permitir atualização de id via set_id', function(){
        assert.throws(function () {
            d0.set_id('outro')
        }, TypeError);
        assert.equal('prog1', d0.id());
    });

});

describe('factory Turma', function () {
    let d0;

    before(async () => {
        d0 = disciplina('prog1', 'Programação 1', 4, []);
        t0 = turma(d0, 'primeiro');
    })

    it('deve criar turmas distintas a cada invocacao', function() {
        t0 = turma(d0, 'primeiro');
        t1 = turma(d0, 'primeiro');
        t2 = turma(d0, 'primeiro');

        assert.notEqual(t0, t1);
        assert.notEqual(t0, t2);
        assert.notEqual(t1, t2);
    })

    it('deve reter os dados de inicializacao', function () {
        d1 = disciplina('prog2', 'Programação 2', 4, []);
        d2 = disciplina('eda', 'Estrutura de dados', 4, []);

        //todo: criacao dos objetos
        t1 = turma(d1, 'segundo');
        t2 = turma(d2, 'terceiro');

        //todo: asserts
        assert.equal(d0, t0.get_disciplina());
        assert.equal('primeiro', t0.get_periodo());
        
        assert.equal(d1, t1.get_disciplina());
        assert.equal('segundo', t1.get_periodo());

        assert.equal(d2, t2.get_disciplina());
        assert.equal('terceiro', t2.get_periodo());
    })

    it('deve permitir edicao do professor', function () {
        p0 = professor('1234', 'dalton', 'dalton@ccc', '9876', 'https://foto.com');

        assert.equal(t0.get_professor(), null);

        t0.set_professor(p0);

        assert.equal(t0.get_professor(), p0);        
    })

    it('deve permitir cadastro de estudantes nas circunstancias adequadas', function () {
        e0 = estudante('m1234', 'iago', 'iago@ccc', 'c1234', 'https://foto_iago.com');
        e1 = estudante('m5678', 'diego', 'diego@ccc', 'c5678', 'https://foto_diego.com');
        e2 = estudante('m91011', 'paulo', 'paulo@ccc', 'c91011', 'https://foto_paulo.com');

        t1 = turma(d1, 'segundo');
        t1.set_status('concluida');

        // todo
    })
})
