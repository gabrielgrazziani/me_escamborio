package dev.gabrielgrazziani.meEscamborio.teste;

import dev.gabrielgrazziani.meEscamdori.model.MensagemDao;

public class TesteMensagem {

	public static void main(String[] args) {
		MensagemDao mensagemDao = new MensagemDao();
		
		//List<Mensagem> index = mensagemDao.index();
		//index.forEach(System.out::println);
		
//		Mensagem mensagem = mensagemDao.getMensagem(1L);
//		
//		mensagem.setMensagem("oiiii");
//		
//		mensagemDao.save(mensagem);
		
		mensagemDao.excluir(1L);
		
		mensagemDao.close();
	}

}
