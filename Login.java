import java.sql.*;

import javax.swing.*;

import javax.swing.text.*;

import java.awt.*;

import java.awt.event.*;

import java.text.*;



public class Login extends JFrame  implements ActionListener{

	ResultSet resultSet;
 	 Statement statement;

	JLabel jlIcone;

	JLabel rotulouserName,rotulosenha;

	JPasswordField jpsenha;

	JButton btnEntrar, btn_add;

	JTextField userName;

	public static void main(String args[]){

				

		JFrame janela = new Login();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);

		

	}

 Login(){

		

		super("AF-Sistema - Faça login");

		Container tela = getContentPane();
		
		
		JLabel jlIcone = new JLabel(new ImageIcon("icon.png"));
		jlIcone.setBounds(60,45,250,250);
		

		setLayout(null);

		getContentPane().add(jlIcone);
		getContentPane().setBackground(new Color(27,75,153));
				

		setLocationRelativeTo(null);

		

		rotulouserName = new JLabel("Usuario: ");

		rotulouserName.setBounds(50,200,100,20);

		rotulouserName.setForeground(new java.awt.Color(229,229,229));

		

		rotulosenha = new JLabel("Senha:");

		rotulosenha.setBounds(50,242,100,20);

		rotulosenha.setForeground(new java.awt.Color(229,229,229));

		

		btnEntrar = new JButton("Login");

		btnEntrar.setBounds(120,300,100,20);

		btnEntrar.addActionListener(this);

		tela.add(btnEntrar);

		
		

		//Campo de Usuario

		userName = new JTextField(10);

		userName.setBounds(50,220,250,25);

		userName.setBackground(new Color(18,20,32));

		userName.setForeground(new java.awt.Color(229,229,229));

		userName.setBorder(null);

		tela.add(rotulouserName);

		tela.add(userName);

		

		//Campo de Senha

		jpsenha = new JPasswordField(8);

		jpsenha.setBounds(50,260,250,25);

		jpsenha.setBackground(new Color(18,20,32));

		jpsenha.setForeground(new java.awt.Color(229,229,229));

		jpsenha.setBorder(null);

		tela.add(rotulosenha);

		tela.add(jpsenha);

		

		

		setSize(360,540);

		setVisible(true);

		setLocationRelativeTo(null);
		
		carregaResultSet();	

}
public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == btnEntrar) {
	        	carregaResultSet();
	        	if(pass == 1){
					UIManager.put("OptionPane.background", new Color(166, 163, 255));
		            UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(166, 163, 255));
		            JOptionPane.showMessageDialog(null,"Conectado");
		            
		            afsistema janela = new afsistema();
		            
		            janela.setVisible(true);
		            janela.setResizable(false);
		            dispose();
				}else{
		        	UIManager.put("OptionPane.background", new Color(237, 102, 0));
		            //UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(234, 189, 39));
		            JOptionPane.showMessageDialog(null,"Usuario ou senha incorreto, tente novamente.","Não foi possivel acessar o sistema", JOptionPane.ERROR_MESSAGE);
		       	}
	        }
}
int pass = 0;
	public void carregaResultSet(){
			String url = "jdbc:mysql://127.0.0.1:3306/afsistemadb?useSSL=false";
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection minhaConexao = DriverManager.getConnection(url,"root","");
				statement = minhaConexao.createStatement(resultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);;
												  //SELECT * FROM usuario WHERE `username` = '' AND `senha` = ''
				resultSet = statement.executeQuery("SELECT * FROM userlogin WHERE `userName` = '"+userName.getText()+"' AND `senha` = '"+jpsenha.getText()+"'");
				
				resultSet.last();
				pass = resultSet.getRow();
			}catch(ClassNotFoundException erro){
				System.out.println("Driver nao encontrado");
			}
			catch(SQLException erro){				
				System.out.println("Problemas na conexao com a fonte de dados"); 
			}
	}

    	

	

	

	

}