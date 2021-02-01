import java.sql.*;

import javax.swing.*;

import javax.swing.text.*;

import java.awt.*;

import java.awt.event.*;

import java.text.*;

import javax.swing.JButton;


public class cadastro_usuario extends JFrame implements ActionListener
{
ResultSet resultSet;
	Statement statement;
	

	JLabel jlIcone;

	JLabel rotulouserName,rotulosenha, nome_usuario, cad_endereco, cad_numero, cad_cod, cad_email, cad_cep;

	JPasswordField jpsenha;

	JButton btGravar,
			btAlterar,
			btExcluir,
			btlocalizar,
			btNovo,
			btCancelar,
			add;

static	JTextField userName, senha, usuario, endereco, numero, cod, email, cep;
		public static void main(String args[]){
		JFrame janela = new cadastro_usuario();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
cadastro_usuario(){

		

		super("AF-Sistema - Usuario");

		Container tela = getContentPane();
		
		//adicionar usuario
		add = new JButton(new ImageIcon("user.png"));
		add.setBounds(75,255,190,190);
		add.setBackground(new Color(27,75,153));
		getContentPane().add(add);
		//add.setBorder(null);
		
		
		//add.setBorder(null);

		setLayout(null);

		//getContentPane().add(jlIcone);
		getContentPane().setBackground(new Color(27,75,153));
				

		setLocationRelativeTo(null);
		
		//cadastro{
		cad_cod = new JLabel("CODIGO: ");
		cod = new JTextField();
		cad_cod.setBounds(20,20,100,20);
		cod.setBounds(95,20,40,20);
		cad_cod.setForeground(new java.awt.Color(229,229,229));
		tela.add(cad_cod); tela.add(cod);
		
		nome_usuario = new JLabel("NOME: ");
		usuario = new JTextField();
		nome_usuario.setBounds(20,60,100,20);
		usuario.setBounds(95,60,220,20);
		nome_usuario.setForeground(new java.awt.Color(229,229,229));	
		tela.add(nome_usuario); tela.add(usuario);
		
		cad_endereco = new JLabel("ENDEREÇO: ");
		endereco = new JTextField();
		cad_endereco.setBounds(20,100,100,20);
		endereco.setBounds(95,100,220,20);
		cad_endereco.setForeground(new java.awt.Color(229,229,229));
		tela.add(cad_endereco); tela.add(endereco);
		
		cad_numero = new JLabel("NUMERO: ");
		numero = new JTextField();
		cad_numero.setBounds(20,140,100,20);
		numero.setBounds(95,140,50,20);
		cad_numero.setForeground(new java.awt.Color(229,229,229));
		tela.add(cad_numero); tela.add(numero);
		
		cad_cep = new JLabel("CEP: ");
		cep = new JTextField();		
		cad_cep.setBounds(20,180,100,20);
		cep.setBounds(95,180,120,20);
		cad_cep.setForeground(new java.awt.Color(229,229,229));
		tela.add(cad_cep); tela.add(cep);
		
		cad_email = new JLabel("EMAIL: ");
		email = new JTextField();
		cad_email.setBounds(20,220,100,20);
		email.setBounds(95,220,220,20);
		cad_email.setForeground(new java.awt.Color(229,229,229));
		tela.add(cad_email); tela.add(email);
		
		//login{
		rotulouserName = new JLabel("Usuario: ");

		rotulouserName.setBounds(50,460,100,20);

		rotulouserName.setForeground(new java.awt.Color(229,229,229));

		

		rotulosenha = new JLabel("Senha:");

		rotulosenha.setBounds(50,500,100,20);

		rotulosenha.setForeground(new java.awt.Color(229,229,229));
		//}

		

		//Campo de Usuario

		userName = new JTextField();

		userName.setBounds(50,480,250,25);

		userName.setBackground(new Color(18,20,32));

		userName.setForeground(new java.awt.Color(229,229,229));

		userName.setBorder(null);

		tela.add(rotulouserName);

		tela.add(userName);

		

		//Campo de Senha

		senha = new JTextField();

		senha.setBounds(50,520,250,25);

		senha.setBackground(new Color(18,20,32));

		senha.setForeground(new java.awt.Color(229,229,229));

		senha.setBorder(null);

		tela.add(rotulosenha);

		tela.add(senha);

		
		btGravar = new JButton();
  			btGravar.setText("Gravar");
           	btGravar.setBounds(10,550,100,30);
           	btGravar.setSize(80,25);
           	btGravar.setBackground(new Color(27,75,153));
			btGravar.setForeground(Color.white);
			btGravar.setFont(new Font("Tahoma",Font.BOLD,10));
			btGravar.addActionListener(this);
			tela.add(btGravar);
            
            btAlterar = new JButton();
  			btAlterar.setText("Alterar");
           	btAlterar.setBounds(100,550,100,30);
           	btAlterar.setSize(80,25);
           	btAlterar.setBackground(new Color(27,75,153));
			btAlterar.setForeground(Color.white);
			btAlterar.setFont(new Font("Tahoma",Font.BOLD,10));
			btAlterar.addActionListener(this);
            tela.add(btAlterar);
            
            btExcluir = new JButton();
  			btExcluir.setText("Excluir");
           	btExcluir.setBounds(53,580,100,30);
           	btExcluir.setSize(80,25);
           	btExcluir.setBackground(new Color(27,75,153));
			btExcluir.setForeground(Color.white);
			btExcluir.setFont(new Font("Tahoma",Font.BOLD,10));
			btExcluir.addActionListener(this);
            tela.add(btExcluir);
            
            btlocalizar = new JButton();
  			btlocalizar.setText("Localizar");
           	btlocalizar.setBounds(223,580,100,30);
           	btlocalizar.setSize(80,25);
           	btlocalizar.setBackground(new Color(27,75,153));
			btlocalizar.setForeground(Color.white);
			btlocalizar.setFont(new Font("Tahoma",Font.BOLD,10));
			btlocalizar.addActionListener(this);
            tela.add(btlocalizar);
            
            btNovo = new JButton();
  			btNovo.setText("Novo");
           	btNovo.setBounds(190,550,100,30);
           	btNovo.setSize(80,25);
           	btNovo.setBackground(new Color(27,75,153));
			btNovo.setForeground(Color.white);
			btNovo.setFont(new Font("Tahoma",Font.BOLD,10));
			btNovo.addActionListener(this);
            tela.add(btNovo);
                                    
            btCancelar = new JButton();
  			btCancelar.setText("Cancelar");
           	btCancelar.setBounds(280,550,100,30);
           	btCancelar.setSize(80,25);
           	btCancelar.setBackground(new Color(27,75,153));
			btCancelar.setForeground(Color.white);
			btCancelar.setFont(new Font("Tahoma",Font.BOLD,10));
			btCancelar.addActionListener(this);
            tela.add(btCancelar);
		
		setBotoes(true,true,false,false,false,false);
            

		setResizable(false);
		
		carregaResultSet();

		setSize(370,650);

		setVisible(true);

		setLocationRelativeTo(null);	

}
public void actionPerformed(ActionEvent e)
{

	if(e.getSource()==btNovo)
	{
		limpaCampos();
		setBotoes(false, false,true, false, false,true );
		return;
	}

	if( e.getSource()==btCancelar)
	{
		limpaCampos();
		setBotoes(true,true, false, false, false, false);
		return;
	}
	if(e.getSource()==btGravar)
    //gravar registro novo
   	{
	try
	{
	
	String sql="INSERT INTO userlogin(cod,usuario,endereco,numero,cep,email,userName,senha)Values('"+
		cod.getText()+"','"+
		usuario.getText()+"','"+
		endereco.getText()+"','"+
		numero.getText()+"','"+
		cep.getText()+"','"+
		email.getText()+"','"+
		userName.getText()+"','"+
		senha.getText()+"')";
		
		statement.executeUpdate(sql);
		
	JOptionPane.showMessageDialog(null,"Gravacao realizada com sucesso");
	setBotoes(true,true,false,true,true,false);
	}
	catch(SQLException erro)
	{
	}
	carregaResultSet();
	}
	// --Final da inclusao
	
	//alterar um registro
	if(e.getSource()== btAlterar)
	{
try
		{
			String sql = "UPDATE userlogin SET " +
			
		"cod ='"+ cod.getText()+"',"+
		"usuario ='"+ usuario.getText()+"',"+
		"endereco ='"+ endereco.getText()+"',"+
		"numero ='"+ numero.getText()+"',"+
		"cep ='"+ cep.getText()+"',"+
		"email ='"+ email.getText()+"',"+
		"userName ='"+ userName.getText()+"',"+
		"senha ='"+senha.getText()+"'"+
		"WHERE cod ='"+ cod.getText()+"'";
			int r = statement.executeUpdate(sql);
		
			if(r==1)
				JOptionPane.showMessageDialog(null,"Problemas na alteracao");
			else
				JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso");
				setBotoes(true,true,true,true,true,true);
				}
		
				catch(SQLException erro)
					{
						JOptionPane.showMessageDialog(null,"Atualização nao realizada");
					}
					carregaResultSet();
	}
//-------------Final da alteracao
		if(e.getSource()==btExcluir)
		//Excluir um registro
		{
			try
				{
				String sql="SELECT cod, usuario FROM userlogin Where cod='" +cod.getText()+"'";
    				resultSet=statement.executeQuery(sql);
				String nome="";
			try 
				{
				resultSet.next(); nome="Deletar o Cadastro: " + resultSet.getString("usuario"); 
					} 
			catch(SQLException exl)
				{
				JOptionPane.showMessageDialog(null, "Cadastrado nao efetuado");
				carregaResultSet(); return; }
				int n = JOptionPane.showConfirmDialog(null,nome,"",JOptionPane.YES_NO_OPTION);
				if (n==JOptionPane.YES_OPTION)
					{
						sql="DELETE FROM userlogin Where cod='"+cod.getText()+"'";
						int r=statement.executeUpdate(sql); 
							if(r==1)
							JOptionPane.showMessageDialog(null, "Exclusao realizada com sucesso");
							else
							JOptionPane.showMessageDialog(null, "Nao foi possivel excluir o Cadastro");
							limpaCampos();
							setBotoes(true,true,false,false,false,false);
							} 
							}
							catch(SQLException erro) {}
							carregaResultSet(); 
								}
						//-------------Final da exclusao
					if(e.getSource()==btlocalizar || e.getSource()==cod)
						{
							try
								{
								String sql ="SELECT * FROM userlogin Where cod ='" +cod.getText()+"'";
								
								resultSet=statement.executeQuery(sql);
								resultSet.next();
								atualizaCampos();
								setBotoes(true,true, false,true, true, false);
						}
								catch(SQLException erro)
									{
									JOptionPane.showMessageDialog(null,"Cadastro nao encontrado");
									carregaResultSet();
									return;
									}
									}
		
}							
//-------------------Final da localizacao
	
public void carregaResultSet(){
	String url="jdbc:mysql://localhost/afsistemadb";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection minhaConexao=DriverManager.getConnection(url,"root","");
			statement=minhaConexao.createStatement(resultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);;
			resultSet=statement.executeQuery("SELECT * FROM userlogin");
			}
		catch(ClassNotFoundException erro)
			{
			System.out.println("Driver nao encontrado");
			}
			catch(SQLException erro)
				{				
			System.out.println("Problemas na conexao com a fonte de dados"); 
				}
				}
				
			public static void limpaCampos()
			{
						cod.setText("");
						usuario.setText("");
						endereco.setText("");
						numero.setText("");
						cep.setText("");
						email.setText("");
						userName.setText("");
						senha.setText("");
			}

public void atualizaCampos()
{
try
{
	
						cod.setText(resultSet.getString("cod"));
						usuario.setText(resultSet.getString("usuario"));						
						endereco.setText(resultSet.getString("endereco"));
						numero.setText(resultSet.getString("numero"));
						cep.setText(resultSet.getString("cep"));
						email.setText(resultSet.getString("email"));
						userName.setText(resultSet.getString("userName"));
						senha.setText(resultSet.getString("senha"));
}
catch(SQLException erro){}
}
public void setBotoes(boolean bNovo, boolean blocalizar, boolean bGravar, boolean bAlterar, boolean bExcluir, boolean bCancelar)
{
	btNovo.setEnabled(bNovo);
	btlocalizar.setEnabled(blocalizar);
	btGravar.setEnabled(bGravar);
	btAlterar.setEnabled(bAlterar);
	btExcluir.setEnabled(bExcluir);
	btCancelar.setEnabled(bCancelar);
}
		
}