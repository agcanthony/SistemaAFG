import java.sql.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.JButton;

public class cadastro_cpf extends JFrame implements ActionListener{
	ResultSet resultSet;
	Statement statement;
	JLabel 	DE,
			rotuloCod,
			rotuloNome,
			rotuloCPF,
			rotuloRG,
			rotuloEmailP,
			rotuloEmailC,
			rotuloTelF,
			rotuloTelW,
			rotuloCep,
			rotuloEnd,
			rotuloNu,
			rotuloCidade,
			rotuloEstado,
			rotuloDescri;
			
			
//-----------------------------------------------------//

static	JTextField Cod,
						Nome,
						CPF,
						RG,
						EmailP,
						EmailC,
						TelF,
						TelW,
						Cep,
						End,
						Nu,
						Cidade,
						Estado,
						Descri;
						
						
//-----------------------------------------------------//

	MaskFormatter 	mascaraCod,
					mascaraNome,
					mascaraCPF,
					mascaraRG,
					mascaraEmailP,
					mascaraEmailC,
					mascaraTelF,
					mascaraTelW,
					mascaraCep,
					mascaraEnd,
					mascaraNu,
					mascaraCidade,
					mascaraEstado,
					mascaraDescri;				
					
//------------------------------------------------------//


	JButton btGravar,
			btAlterar,
			btExcluir,
			btlocalizar,
			btNovo,
			btCancelar;
			
//-------------------------------------------------------//

JScrollPane caixa1;

//-------------------------------------------------------//
public static void main(String args[])
{
	    JFrame janela = new cadastro_cpf();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
}
	 cadastro_cpf(){
		super("Cadastro de Pessoa Fisica");

		DE=new JLabel("Dados Pessoais");
		DE.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        DE.setForeground(new java.awt.Color(100, 10, 0));


		Container tela = getContentPane();
		setLayout(null);
		rotuloCod = new JLabel("Código: ");
		rotuloNome = new JLabel("Nome Completo: ");
		rotuloCPF = new JLabel("CPF: ");
		rotuloRG = new JLabel("RG: ");
		rotuloEmailP = new JLabel("E-mail Pessoal: ");
		rotuloEmailC = new JLabel("E-mail Comercial: ");
		rotuloTelF = new JLabel("Telefone Fixo: ");
		rotuloTelW = new JLabel("Telefone WhatsApp: ");
		rotuloCep = new JLabel("CEP: ");
		rotuloEnd = new JLabel("Endereço: ");
		rotuloNu = new JLabel ("Nº:");
		rotuloCidade = new JLabel("Cidade: ");
		rotuloEstado = new JLabel("Estado: ");
		rotuloDescri = new JLabel("Descrições: ");

		DE.setBounds(320,30,400,50);
		rotuloCod.setBounds(100,120,120,20);
		rotuloNome.setBounds(445,120,100,20);
		rotuloCPF.setBounds(100,160,100,20);
		rotuloRG.setBounds(445,160,120,20);
		rotuloEmailP.setBounds(100,200,100,20);
		rotuloEmailC.setBounds(445,200,120,20);
		rotuloTelF.setBounds(100,240,120,20);
		rotuloTelW.setBounds(445,240,120,20);
		rotuloCep.setBounds(100,280,100,20);
		rotuloEnd.setBounds(445,280,100,20);
		rotuloNu.setBounds(775,280,100,20);
		rotuloCidade.setBounds(100,320,100,20);
		rotuloEstado.setBounds(445,320,100,20);
		rotuloDescri.setBounds(100,360,100,20);

	try{
		mascaraCod =new MaskFormatter("#####");
		mascaraNome = new MaskFormatter("**********************************************");
		mascaraCPF = new MaskFormatter("###.###.###-##");
		mascaraRG = new MaskFormatter("**********************");
		mascaraEmailP = new MaskFormatter("*********************************************");
		mascaraEmailC = new MaskFormatter("*********************************************");
		mascaraTelF = new MaskFormatter("(##)####-####");
		mascaraTelW = new MaskFormatter("(##)#.####-####");
		mascaraCep = new MaskFormatter("#####-###");
		mascaraEnd = new MaskFormatter("*******************************");
		mascaraNu = new MaskFormatter("*******************************");
		mascaraCidade = new MaskFormatter("****************************");
		mascaraEstado = new MaskFormatter("****************************");
		
		
		mascaraCod.setPlaceholderCharacter('_');
		mascaraNome.setPlaceholderCharacter('_');
		mascaraCPF.setPlaceholderCharacter('_');
		mascaraRG.setPlaceholderCharacter('_');
		mascaraEmailP.setPlaceholderCharacter('_');
		mascaraEmailC.setPlaceholderCharacter('_');
		mascaraTelF.setPlaceholderCharacter('_');
		mascaraTelW.setPlaceholderCharacter('_');
		mascaraCep.setPlaceholderCharacter('_');
		mascaraEnd.setPlaceholderCharacter('_');
		mascaraNu.setPlaceholderCharacter('_');
		mascaraCidade.setPlaceholderCharacter('_');
		mascaraEstado.setPlaceholderCharacter('_');
		
		

	}
	catch(ParseException excp){}
		Cod = new JTextField(6);
		Nome = new JTextField(70);
		CPF = new JTextField(14);
		RG = new JTextField(20);
		EmailP = new JTextField(70);
		EmailC = new JTextField(70);
		TelF = new JTextField(11);
		TelW = new JTextField(12);
		Cep = new JTextField(12);
		End = new JTextField(30);
		Nu = new JTextField(9);
		Cidade = new JTextField(10);
		Estado = new JTextField(15);
		Descri = new JTextField(150);

		Cod.setBounds(225,120,41,20);
		Nome.setBounds(565,120,200,20);
		CPF.setBounds(225,160,95,20);
		RG.setBounds(565,160,127,20);
		EmailP.setBounds(225,200,200,20);
		EmailC.setBounds(565,200,200,20);
		TelF.setBounds(225,240,88,20);
		TelW.setBounds(565,240,98,20);
		Cep.setBounds(225,280,67,20);
		End.setBounds(565,280,200,20);
		Nu.setBounds(795,280,41,20);
		Cidade.setBounds(225,320,120,20);
		Estado.setBounds(565,320,100,20);
		Descri.setBounds(225,360,615,100);
		

		tela.add(DE);
		tela.add(rotuloCod);
		tela.add(rotuloNome);
		tela.add(rotuloCPF);
		tela.add(rotuloRG);
		tela.add(rotuloEmailP);
		tela.add(rotuloEmailC);
		tela.add(rotuloTelF);
		tela.add(rotuloTelW);
		tela.add(rotuloCep);
		tela.add(rotuloEnd);
		tela.add(rotuloNu);
		tela.add(rotuloCidade);
		tela.add(rotuloEstado);
		tela.add(rotuloDescri);

		tela.add(Cod);
		tela.add(Nome);
		tela.add(CPF);
		tela.add(RG);
		tela.add(EmailP);
		tela.add(EmailC);
		tela.add(TelF);
		tela.add(TelW);
		tela.add(Cep);
		tela.add(End);
		tela.add(Nu);
		tela.add(Cidade);
		tela.add(Estado);
		tela.add(Descri);
		
			btGravar = new JButton();
  			btGravar.setText("Salvar");
           	btGravar.setBounds(80,500,100,30);
           	btGravar.setSize(100,25);
           	btGravar.setBackground(new Color(27,75,153));
			btGravar.setForeground(Color.white);
			btGravar.setFont(new Font("Tahoma",Font.BOLD,14));
			btGravar.addActionListener(this);
			tela.add(btGravar);
            
            btAlterar = new JButton();
  			btAlterar.setText("Alterar");
           	btAlterar.setBounds(215,500,100,30);
           	btAlterar.setSize(100,25);
           	btAlterar.setBackground(new Color(27,75,153));
			btAlterar.setForeground(Color.white);
			btAlterar.setFont(new Font("Tahoma",Font.BOLD,14));
			btAlterar.addActionListener(this);
            tela.add(btAlterar);
            
            btExcluir = new JButton();
  			btExcluir.setText("Excluir");
           	btExcluir.setBounds(350,500,100,30);
           	btExcluir.setSize(100,25);
           	btExcluir.setBackground(new Color(27,75,153));
			btExcluir.setForeground(Color.white);
			btExcluir.setFont(new Font("Tahoma",Font.BOLD,14));
			btExcluir.addActionListener(this);
            tela.add(btExcluir);
            
            btlocalizar = new JButton();
  			btlocalizar.setText("Localizar");
           	btlocalizar.setBounds(485,500,100,30);
           	btlocalizar.setSize(100,25);
           	btlocalizar.setBackground(new Color(27,75,153));
			btlocalizar.setForeground(Color.white);
			btlocalizar.setFont(new Font("Tahoma",Font.BOLD,14));
			btlocalizar.addActionListener(this);
            tela.add(btlocalizar);
            
            btNovo = new JButton();
  			btNovo.setText("Novo");
           	btNovo.setBounds(620,500,100,30);
           	btNovo.setSize(100,25);
           	btNovo.setBackground(new Color(27,75,153));
			btNovo.setForeground(Color.white);
			btNovo.setFont(new Font("Tahoma",Font.BOLD,14));
			btNovo.addActionListener(this);
            tela.add(btNovo);
                                    
            btCancelar = new JButton();
  			btCancelar.setText("Cancelar");
           	btCancelar.setBounds(755,500,100,30);
           	btCancelar.setSize(100,25);
           	btCancelar.setBackground(new Color(27,75,153));
			btCancelar.setForeground(Color.white);
			btCancelar.setFont(new Font("Tahoma",Font.BOLD,14));
			btCancelar.addActionListener(this);
            tela.add(btCancelar);
            
            
            setBotoes(true,true,false,false,false,false);


        
			caixa1 = new JScrollPane(null);
			caixa1.setBounds(80,100,780,380);
			tela.add(caixa1);

		setResizable(false);
		carregaResultSet();
		setSize(920,600);
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
	
	String sql="INSERT INTO cadastrocpf(Cod,Nome,CPF,RG,EmailP,EmailC,TelF,TelW,Cep,EndR,Nu,Cidade,Estado,Descri)Values('"+
		Cod.getText()+"','"+
		Nome.getText()+"','"+
		CPF.getText()+"','"+
		RG.getText()+"','"+
		EmailP.getText()+"','"+
		EmailC.getText()+"','"+
		TelF.getText()+"','"+
		TelW.getText()+"','"+
		Cep.getText()+"','"+
		End.getText()+"','"+
		Nu.getText()+"','"+
		Cidade.getText()+"','"+
		Estado.getText()+"','"+
		Descri.getText()+"')";
	
	statement.executeUpdate(sql);
	JOptionPane.showMessageDialog(null,"Gravacao realizada com sucesso");
	setBotoes(true,true, false,true,true, false);
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
			String sql = "UPDATE cadastrocpf SET " +
			
		"Cod ='"+ Cod.getText()+"',"+
		"Nome ='"+ Nome.getText()+"',"+
		"CPF ='"+ CPF.getText()+"',"+
		"RG ='" + RG.getText()+"',"+
		"EmailP ='"+ EmailP.getText()+"',"+
		"EmailC ='"+ EmailC.getText()+"',"+
		"TelF ='"+ TelF.getText()+"',"+
		"TelW ='"+ TelW.getText()+"',"+
		"CEP ='"+ Cep.getText()+"',"+
		"EndR ='"+ End.getText()+"',"+
		"Cidade ='"+ Cidade.getText()+"',"+
		"Estado ='"+ Estado.getText()+"',"+
		"Descri ='"+Descri.getText()+"',"+
		"Cod ='"+ Cod.getText()+"'";
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
				String sql="SELECT Cod, Nome FROM cadastrocpf Where Cod='" +Cod.getText()+"'";
    				resultSet=statement.executeQuery(sql);
				String nome="";
			try 
				{
				resultSet.next(); nome="Deletar o Cadastro: " + resultSet.getString("Nome"); 
					} 
			catch(SQLException exl)
				{
				JOptionPane.showMessageDialog(null, "Cadastrado nao efetuado");
				carregaResultSet(); return; }
				int n = JOptionPane.showConfirmDialog(null,nome,"",JOptionPane.YES_NO_OPTION);
				if (n==JOptionPane.YES_OPTION)
					{
						sql="DELETE FROM cadastrocpf Where Cod='"+Cod.getText()+"'";
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
						
					//localizar	
			if(e.getSource()==btlocalizar || e.getSource()==Cod)
						{
							try
								{
								String sql ="SELECT * FROM cadastrocpf Where Cod ='"+ Cod.getText()+"'";
								
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
//String
	//url="jdbc:mysql://localhost:3306/cadastro_cpf";
	String url="jdbc:mysql://127.0.0.1:3306/afsistemadb";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection minhaConexao=DriverManager.getConnection(url,"root","");
			statement=minhaConexao.createStatement(resultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);;
			resultSet=statement.executeQuery("SELECT * FROM cadastrocpf");
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
						Cod.setText("");
						Nome.setText("");
						CPF.setText("");
						RG.setText("");
						EmailP.setText("");
						EmailC.setText("");
						TelF.setText("");
						TelW.setText("");
						Cep.setText("");
						End.setText("");
						Nu.setText("");
						Cidade.setText("");
						Estado.setText("");
						Descri.setText("");
			}

public void atualizaCampos()
{
try
{
	
						Cod.setText(resultSet.getString("Cod"));
						Nome.setText(resultSet.getString("Nome"));
						CPF.setText(resultSet.getString("CPF"));
						RG.setText(resultSet.getString("RG"));
						EmailP.setText(resultSet.getString("EmailP"));
						EmailC.setText(resultSet.getString("EmailC"));
						TelF.setText(resultSet.getString("TelF"));
						TelW.setText(resultSet.getString("TelW"));
						Cep.setText(resultSet.getString("CEP"));
						End.setText(resultSet.getString("EndR"));
						Nu.setText(resultSet.getString("Nu"));
						Cidade.setText(resultSet.getString("Cidade"));
						Estado.setText(resultSet.getString("Estado"));
						Descri.setText(resultSet.getString("Descri"));
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



