package br.com.cadastro.cadastro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Cliente {
	private String nome;
	private String email;
	private int idade;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}


	public String salvar() throws IOException {
		//File e uma classe com metodos que permite utilizar arquivos
		//OBS: caminho deve ser adaptado de acordo com a máquina do usuário.
		File fl = new File("C:\\Users\\junio\\OneDrive\\Documentos\\JAVA\\teste\\"+this.nome+".txt");
		
		if(!fl.exists()) {
			try {
			fl.createNewFile();
			FileWriter writer = new FileWriter(fl);
			writer.write(this.nome + " - " +this.email + " - " + this.idade);
			writer.flush();
			writer.close();
			
			}catch(Exception ex){
				return  "Erro ao criar o arquivo, Msg" + ex.getMessage();
			}
		}
		return "sucesso ao cadastrar";
		
		
	}
}
