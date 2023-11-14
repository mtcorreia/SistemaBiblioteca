package br.com.senac.inicializacao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Disciplina;
import br.com.senac.entity.Professor;
import br.com.senac.entity.Turma;
import br.com.senac.repository.AlunoRepository;
import br.com.senac.service.DisciplinaService;
import br.com.senac.service.ProfessorService;
import br.com.senac.service.TurmaService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	AlunoRepository alunoRepo;
	
	@Autowired
	TurmaService turmaService;
	
	@Autowired
	DisciplinaService disciplinaService;
	
	@Autowired
	ProfessorService profService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Arthur");
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("João");
		
		Aluno aluno4 = new Aluno();
		aluno4.setNome("Pedro");
		
		alunoRepo.saveAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4));
		
		Turma ads = new Turma();
		ads.setNome("ADS");
		
		Turma rede = new Turma();
		rede.setNome("Rede");
		
		turmaService.salvar(ads);
		turmaService.salvar(rede);
		
		// turmaService.excluir(1);
		
		List<Turma> listaTurmas = turmaService.listaTodasTurmas();
		for (Turma turma : listaTurmas) {
			System.out.println("Nome da Turma: " + turma.getNome());
		}
		
		
		Turma turmaAlterar = new Turma();
		turmaAlterar.setId(2);
		turmaAlterar.setNome("Redes");
		turmaService.alterar(turmaAlterar);
		
		Turma turma2 = turmaService.buscaPorId(2);
		System.out.println(turma2.getNome());
		
		Disciplina java = new Disciplina();
		java.setNome("Java 1");
		
		Disciplina java2 = new Disciplina();
		java2.setNome("Java 2");
		
		disciplinaService.salvar(java);
		disciplinaService.salvar(java2);
		
		Professor prof1 = new Professor();
		prof1.setNome("Reinaldo");
		
		Professor prof2 = new Professor();
		prof2.setNome("Clayton");
		
		profService.salvar(prof1);
		profService.salvar(prof2);
		
	}
	
}