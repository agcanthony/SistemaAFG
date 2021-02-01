import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.sql.*;
import javax.swing.JButton.*;
import javax.swing.Timer;
import java.text.DecimalFormat;
import java.util.*;
import java.awt.BorderLayout;
//--------------------------------------------------//

public class MenuPedido extends JFrame implements ActionListener
{
	ResultSet resultSet, resultSet2;
	Statement statement, statement2;

	JLabel 	DE,
			cliente,
			rotuloValorProduto,
			rotuloPedido,
			rotulosenha,
			rotuloCPF,
			rotuloCNPJ,
			rotuloProduto1,
			rotuloprod,
			rotuloCod,
			rotuloData;

//------------------------------------------------//
	

			
//--------------------------------------------//
	
	static	JTextField  Pedido,
						senha,
						CPF,
						CNPJ,
						ValorProduto,
						Produto1,
						Cod,
						DataP;
					
					
//--------------------------------------------//

 	JButton btGravar,
			btAlterar,
			btExcluir,
			btlocalizar,
			btlocalizar2,
			btNovo,
			btCancelar;
//--------------------------------------------//
	
	JScrollPane caixa,
				caixa2;
	
//--------------------------------------------//

private JTextField DataPed;
				int ds,dia,mes,ano;
				Calendar data;
				String diasemana[]={"Domingo","Segunda-Feira","terça-Feira","Quarta-Feira","Quinta-Feira","Sexta-Feira","Sabado"};
				String meses[]={"01","02","03","04","05","06","07","08","09","10","11","12"};


public static void main(String args[])
{
	    JFrame janela = new MenuPedido();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
}
		MenuPedido(){

		super("Pedido");

		
		DE=new JLabel("Gerar Pedidos");
		DE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DE.setForeground(new java.awt.Color(100, 10, 0));
        DE.setBounds(160,20,200,20);
	 	
	 	//Rotulo
	 	
	 	
	 	Container tela = getContentPane();
		setLayout(null);
		
		rotuloData = new JLabel("Data:");
	 	rotuloData.setBounds(250,290,110,30);
		tela.add(rotuloData);
		
		data = Calendar.getInstance();		
		dia = data.get(Calendar.DAY_OF_MONTH);
		mes = data.get(Calendar.MONTH);
		ano = data.get(Calendar.YEAR);
				
		DataPed = new JTextField(" "+dia+"/"+meses[mes]+"/"+ano);
		add(DataPed,BorderLayout.SOUTH);
		DataPed.setForeground(Color.black);
		DataPed.setBounds(290,290,80,30);
	 	
	 	cliente=new JLabel("Pedido");
		cliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cliente.setForeground(new java.awt.Color(100, 10, 0));
        cliente.setBounds(180,110,200,20);
	 	
	 	rotuloPedido = new JLabel("Pedido:");
	 	rotuloPedido.setBounds(55,140,100,20);
	 	
	 	rotulosenha = new JLabel("Senha:");
	 	rotulosenha.setBounds(207,140,100,20);
	 		
	 	rotuloCPF = new JLabel("CPF:");
	 	rotuloCPF.setBounds(55,170,100,20);
	 	
	 	rotuloCNPJ = new JLabel("CNPJ:");
	 	rotuloCNPJ.setBounds(55,200,100,20);
	 	

		
		
//____________________________________________________________________________________________//

//Produtos		
		rotuloCod = new JLabel("Código:");
		rotuloCod.setBounds(60,340,45,20);
		
		rotuloProduto1 = new JLabel("Produto");
		rotuloProduto1.setBounds(60,380,45,20);
		
		
		rotuloValorProduto = new JLabel("Valor R$:");
	 	rotuloValorProduto.setBounds(60,420,100,20);
		
	 		
		rotuloprod = new JLabel("Produto");
		rotuloprod.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rotuloprod.setForeground(new java.awt.Color(100, 10, 0));
		rotuloprod.setBounds(180,350,100,20);
	 	
		
//___________________________________________________________________________________________________//
		

				

	
		Pedido = new JTextField(20);
		Pedido.setBounds(100,140,65,20);
		tela.add(rotuloPedido);
		tela.add(Pedido);
		
		senha = new JTextField(20);
		senha.setBounds(250,140,65,20);
		tela.add(rotulosenha);
		tela.add(senha);
		
		CPF = new JTextField(14);
		CPF.setBounds(100,170,130,20);
		tela.add(rotuloCPF);
		tela.add(CPF);
		
		
		CNPJ = new JTextField(16);
		CNPJ.setBounds(100,200,130,20);
		tela.add(rotuloCNPJ);
		tela.add(CNPJ);
		tela.add(cliente);
//____________________________________________________________________________________//
//Valores dos Produtos

		Cod = new JTextField(6);
		Cod.setBounds(60,360,50,20);
		
		Produto1 = new JTextField(60);
		Produto1.setBounds(60,400,300,20);
		
		ValorProduto = new JTextField(10);
		ValorProduto.setBounds(60,440,60,20);
		
		tela.add(Cod);
		tela.add(rotuloValorProduto);
		tela.add(Produto1);
		tela.add(ValorProduto);
		tela.add(rotuloProduto1);
		tela.add(rotuloValorProduto);
		tela.add(rotuloprod);
		tela.add(rotuloCod);

		
//_________________________________________________________________________________//


		
		tela.add(DE);
		
			btGravar = new JButton();
  			btGravar.setText("Gravar");
           	btGravar.setBounds(10,550,100,30);
           	btGravar.setSize(100,25);
           	btGravar.setBackground(new Color(27,75,153));
			btGravar.setForeground(Color.white);
			btGravar.setFont(new Font("Tahoma",Font.BOLD,14));
			btGravar.addActionListener(this);
			tela.add(btGravar);
            
            btAlterar = new JButton();
  			btAlterar.setText("Alterar");
           	btAlterar.setBounds(115,550,100,30);
           	btAlterar.setSize(100,25);
           	btAlterar.setBackground(new Color(27,75,153));
			btAlterar.setForeground(Color.white);
			btAlterar.setFont(new Font("Tahoma",Font.BOLD,14));
			btAlterar.addActionListener(this);
            tela.add(btAlterar);
            
            btExcluir = new JButton();
  			btExcluir.setText("Excluir");
           	btExcluir.setBounds(220,550,100,30);
           	btExcluir.setSize(100,25);
           	btExcluir.setBackground(new Color(27,75,153));
			btExcluir.setForeground(Color.white);
			btExcluir.setFont(new Font("Tahoma",Font.BOLD,14));
			btExcluir.addActionListener(this);
            tela.add(btExcluir);
            
            btlocalizar = new JButton();
  			btlocalizar.setText("Localizar");
           	btlocalizar.setBounds(325,550,100,30);
           	btlocalizar.setSize(100,25);
           	btlocalizar.setBackground(new Color(27,75,153));
			btlocalizar.setForeground(Color.white);
			btlocalizar.setFont(new Font("Tahoma",Font.BOLD,14));
			btlocalizar.addActionListener(this);
            tela.add(btlocalizar);
            
            btlocalizar2 = new JButton(new ImageIcon("localiza.png"));
  			btlocalizar2.setText("");
           	btlocalizar2.setBounds(115,340,40,40);
           	btlocalizar2.setBackground(new Color(226,179,118));
			btlocalizar2.addActionListener(this);
			btlocalizar2.setBorder(null);
            tela.add(btlocalizar2);
            
            btNovo = new JButton();
  			btNovo.setText("Novo");
           	btNovo.setBounds(53,600,100,30);
           	btNovo.setSize(100,25);
           	btNovo.setBackground(new Color(27,75,153));
			btNovo.setForeground(Color.white);
			btNovo.setFont(new Font("Tahoma",Font.BOLD,14));
			btNovo.addActionListener(this);
            tela.add(btNovo);
                                    
            btCancelar = new JButton();
  			btCancelar.setText("Cancelar");
           	btCancelar.setBounds(273,600,100,30);
           	btCancelar.setSize(100,25);
           	btCancelar.setBackground(new Color(27,75,153));
			btCancelar.setForeground(Color.white);
			btCancelar.setFont(new Font("Tahoma",Font.BOLD,14));
			btCancelar.addActionListener(this);
            tela.add(btCancelar);
            
            
            setBotoes(true,true,true,false,false,false,false);


        	caixa = new JScrollPane(null);
			caixa.setBounds(50,100,320,140);
			tela.add(caixa);
			
			caixa2 = new JScrollPane(null);
			caixa2.setBounds(50,330,320,140);
			tela.add(caixa2);
	
		setResizable(false);
		carregaResultSet();	
		carregaResultSet2();	
		setSize(450,660);
		setLocationRelativeTo(null);
				
	 }
	
		public void actionPerformed(ActionEvent e)
{

	if(e.getSource()==btNovo)
	{
		limpaCampos();
		setBotoes(false, false,true, true, false, false,true);
		return;
	}

	if( e.getSource()==btCancelar)
	{
		limpaCampos();
		setBotoes(true,true, true,false, false, false, false);
		return;
	}
	if(e.getSource()==btGravar)
    //gravar registro novo
   	{
	try
	{

	String sql="INSERT INTO pedido(Pedido,senhas,CPF,CNPJ,Cod,Produto1,ValorProduto,DataPed)Values('"+
		Pedido.getText()+"','"+
		senha.getText()+"','"+
		CPF.getText()+"','"+
		CNPJ.getText()+"','"+
		Cod.getText()+"','"+
		Produto1.getText()+"','"+
		ValorProduto.getText()+"','"+
		DataPed.getText()+"')";
	
	statement.executeUpdate(sql);
	JOptionPane.showMessageDialog(null,"Gravacao realizada com sucesso");
	setBotoes(true,true, true, false,true,true, false);
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
			String sql = "UPDATE pedido SET " +
			
		
		"Pedido ='"+Pedido.getText()+"',"+
		"senhas ='"+ senha.getText()+"',"+
		"CPF ='"+ CPF.getText()+"',"+
		"CNPJ ='"+ CNPJ.getText()+"',"+
		"Cod ='"+ Cod.getText()+"',"+	
		"Produto1 ='"+ Produto1.getText()+"',"+
		"ValorProduto ='"+ ValorProduto.getText()+"',"+
		"DataPed ='"+ DataPed.getText()+"'"+
		"WHERE Pedido ='"+ Pedido.getText()+"'";
			int r = statement.executeUpdate(sql);
		
			if(r==1)
				JOptionPane.showMessageDialog(null,"Problemas na alteracao");
			else
				JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso");
				setBotoes(true,true,true,true, true,true,true);
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
				String sql="SELECT Pedido FROM pedido Where Pedido='" +Pedido.getText()+"'";
    				resultSet=statement.executeQuery(sql);
				String nome="";
			try 
				{
				resultSet.next(); nome ="Deletar o Cadastro: " + resultSet.getString("Pedido"); 
					} 
			catch(SQLException exl)
				{
				JOptionPane.showMessageDialog(null, "Cadastrado nao efetuado");
				carregaResultSet(); return; }
				int n = JOptionPane.showConfirmDialog(null,nome,"",JOptionPane.YES_NO_OPTION);
				if (n==JOptionPane.YES_OPTION)
					{
						sql="DELETE FROM pedido Where Pedido='"+Pedido.getText()+"'";
						int r=statement.executeUpdate(sql); 
							if(r==1)
							JOptionPane.showMessageDialog(null, "Exclusao realizada com sucesso");
							else
							JOptionPane.showMessageDialog(null, "Nao foi possivel excluir o Cadastro");
							limpaCampos();
							setBotoes(true,true,true,false, false,false,false);
							} 
							}
							catch(SQLException erro) {}
							carregaResultSet(); 
								}
						//-------------Final da exclusao
						
						
					if(e.getSource()==btlocalizar || e.getSource()==Pedido)
						{
							try
								{
								String sql ="SELECT * FROM pedido Where Pedido ='"+ Pedido.getText()+"'";
								
								resultSet=statement.executeQuery(sql);
								resultSet.next();
								atualizaCampos();
								setBotoes(true,true, true,false,true, true, false);
						}
								catch(SQLException erro)
									{
									JOptionPane.showMessageDialog(null,"Cadastro nao encontrado");
									carregaResultSet();
									return;
									}
									}
									
					if(e.getSource()==btlocalizar2 || e.getSource()==Cod)
						{
							try
								{
								String sql ="SELECT * FROM cadastroprod Where Cod ='"+ Cod.getText()+"'";
								
								resultSet2=statement2.executeQuery(sql);
								resultSet2.next();
								atualizaCampos2();
								//setBotoes(true,true, true,false,true, true, false);
						}
								catch(SQLException erro)
									{
									JOptionPane.showMessageDialog(null,"Cadastro nao encontrado");
									carregaResultSet2();
									return ;
									}
									}
		
}							
//-------------------Final da localizacao
	
public void carregaResultSet(){
//String
	//url="jdbc:mysql://localhost:3306/cadastro_cpf";
	String url="jdbc:mysql://localhost:3306/afsistemadb";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection minhaConexao=DriverManager.getConnection(url,"root","");
			statement=minhaConexao.createStatement(resultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);;
			resultSet=statement.executeQuery("SELECT * FROM pedido");
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
						
						Pedido.setText("");
						senha.setText("");
						CPF.setText("");
						CNPJ.setText("");
						Cod.setText("");
						Produto1.setText("");
						ValorProduto.setText("");
						
						
			}

public void atualizaCampos()
{
try
{
	
						
						Pedido.setText(resultSet.getString("Pedido"));
						senha.setText(resultSet.getString("senhas"));
						CPF.setText(resultSet.getString("CPF"));
						CNPJ.setText(resultSet.getString("CNPJ"));
						Cod.setText(resultSet.getString("Cod"));
						Produto1.setText(resultSet.getString("Produto1"));
						ValorProduto.setText(resultSet.getString("ValorProduto"));
						DataPed.setText(resultSet.getString("DataPed"));
						
						
}
catch(SQLException erro){}
}

public void carregaResultSet2(){
//String
	//url="jdbc:mysql://localhost:3306/cadastro_cpf";
	String url="jdbc:mysql://localhost:3306/afsistemadb";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection minhaConexao=DriverManager.getConnection(url,"root","");
			statement2=minhaConexao.createStatement(resultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);;
			resultSet2=statement2.executeQuery("SELECT * FROM cadastroprod");
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
				
				public static void limpaCampos2()
			{
						
					
						Cod.setText("");
						Produto1.setText("");
						ValorProduto.setText("");
						
			}

public void atualizaCampos2()
{
try
{
	
						
						
						Cod.setText(resultSet2.getString("Cod"));
						Produto1.setText(resultSet2.getString("Produto1"));
						ValorProduto.setText(resultSet2.getString("ValorProduto"));
						
						
}
catch(SQLException erro){}
}
public void setBotoes(boolean bNovo, boolean blocalizar, boolean blocalizar2, boolean bGravar, boolean bAlterar, boolean bExcluir, boolean bCancelar)
{
	btNovo.setEnabled(bNovo);
	btlocalizar.setEnabled(blocalizar);
	btlocalizar2.setEnabled(blocalizar2);
	btGravar.setEnabled(bGravar);
	btAlterar.setEnabled(bAlterar);
	btExcluir.setEnabled(bExcluir);
	btCancelar.setEnabled(bCancelar);
}
}