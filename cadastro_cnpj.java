import java.sql.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.JButton;


//------------------------------------------------------//
public class cadastro_cnpj extends JFrame implements ActionListener{
	 ResultSet resultSet;
 	 Statement statement;
	JLabel 	DE,
			DR,
			rotuloCod,
			rotuloNome,
			rotuloCNPJ,
			rotuloIns,
			rotuloEmailP,
			rotuloEmailC,
			rotuloTelF,
			rotuloTelW,
			rotuloCep,
			rotuloEnd,
			rotuloNu,
			rotuloCidade,
			rotuloEstado,
			rotuloNomeR,
			rotuloCPF,
			rotuloCepR,
			rotuloEndR,
			rotuloNuR,
			rotuloCidadeR,
			rotuloEstadoR,
			rotuloDesc;
			
			
//-----------------------------------------------------//

		static JTextField Cod,
						Nome,
						CNPJ,
						Ins,
						EmailP,
						EmailC,
						TelF,
						TelW,
						Cep,
						End,
						Nu,
						Cidade,
						Estado,
						NomeR,
						CPF,
						CepR,
						EndR,
						NuR,
						CidadeR,
						EstadoR,
						Descri;
						
						
//-----------------------------------------------------//

	MaskFormatter 	mascaraCod,
					mascaraNome,
					mascaraCNPJ,
					mascaraIns,
					mascaraEmailP,
					mascaraEmailC,
					mascaraTelF,
					mascaraTelW,
					mascaraCep,
					mascaraEnd,
					mascaraNu,
					mascaraCidade,
					mascaraEstado,
					mascaraNomeR,
					mascaraCPF,
					mascaraCepR,
					mascaraEndR,
					mascaraNuR,
					mascaraCidadeR,
					mascaraEstadoR,
					mascaraDesc;				
					
//------------------------------------------------------//


	JButton btGravar,
			btAlterar,
			btExcluir,
			btlocalizar,
			btNovo,
			btCancelar;
			
//-------------------------------------------------------//

JScrollPane caixa1,
			caixa2;

//------------------------------------------------------//

public static void main(String args[])
{
	    JFrame janela = new cadastro_cnpj();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
}
 cadastro_cnpj(){
		super("Cadastro de Pessoa Juridica");
		

		DE=new JLabel("Dados Empresariais");
		DE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DE.setForeground(new java.awt.Color(100, 10, 0));

        DR=new JLabel("Representante");
		DR.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DR.setForeground(new java.awt.Color(100, 10, 0));

		Container tela = getContentPane();
		setLayout(null);
		rotuloCod = new JLabel("Código: ");
		rotuloNome = new JLabel("Razão Social: ");
		rotuloCNPJ = new JLabel("CNPJ: ");
		rotuloIns = new JLabel("Inscrição Estadual: ");
		rotuloEmailP = new JLabel("E-mail Pessoal: ");
		rotuloEmailC = new JLabel("E-mail Comercial: ");
		rotuloTelF = new JLabel("Telefone Fixo: ");
		rotuloTelW = new JLabel("Telefone WhatsApp: ");
		rotuloCep = new JLabel("CEP: ");
		rotuloEnd = new JLabel("Endereço: ");
		rotuloNu = new JLabel("N°: ");
		rotuloCidade = new JLabel("Cidade: ");
		rotuloEstado = new JLabel("Estado: ");
		rotuloNomeR = new JLabel("Nome: ");
		rotuloCPF = new JLabel("CPF: "); 
		rotuloCepR = new JLabel("CEP: ");
		rotuloEndR = new JLabel("Endereço: ");
		rotuloNuR = new JLabel("N°: ");
		rotuloCidadeR = new JLabel("Cidade: ");
		rotuloEstadoR = new JLabel("Estado: ");
		rotuloDesc = new JLabel("Descrições: ");

		DE.setBounds(350,20,200,20);
		DR.setBounds(365,332,200,20);
		rotuloCod.setBounds(100,80,120,20);
		rotuloNome.setBounds(445,80,100,20);
		rotuloCNPJ.setBounds(100,120,100,20);
		rotuloIns.setBounds(445,120,120,20);
		rotuloEmailP.setBounds(100,160,100,20);
		rotuloEmailC.setBounds(445,160,120,20);
		rotuloTelF.setBounds(100,200,120,20);
		rotuloTelW.setBounds(445,200,120,20);
		rotuloCep.setBounds(100,240,100,20);
		rotuloEnd.setBounds(445,240,100,20);
		rotuloNu.setBounds(775,240,100,20);
		rotuloCidade.setBounds(100,280,100,20);
		rotuloEstado.setBounds(445,280,100,20);
		
		rotuloNomeR.setBounds(100,380,100,20);
		rotuloCPF.setBounds(445,380,100,20);
		rotuloCepR.setBounds(100,420,100,20);
		rotuloEndR.setBounds(445,420,100,20);
		rotuloNuR.setBounds(775,420,100,20);
		rotuloCidadeR.setBounds(100,460,100,20);
		rotuloEstadoR.setBounds(445,460,100,20);
		rotuloDesc.setBounds(100,500,100,20);

	try{
		mascaraCod =new MaskFormatter("#####");
		mascaraNome = new MaskFormatter("**********************************************");
		mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
		mascaraIns = new MaskFormatter("###.###.###.###");
		mascaraEmailP = new MaskFormatter("*********************************************");
		mascaraEmailC = new MaskFormatter("*********************************************");
		mascaraTelF = new MaskFormatter("(##)####-####");
		mascaraTelW = new MaskFormatter("(##)#.####-####");
		mascaraCep = new MaskFormatter("#####-###");
		mascaraEnd = new MaskFormatter("*******************************");
		mascaraNu = new MaskFormatter("*******************************");
		mascaraCidade = new MaskFormatter("****************************");
		mascaraEstado = new MaskFormatter("****************************");
		
		mascaraNomeR = new MaskFormatter("**********************************************");
		mascaraCPF = new MaskFormatter("###.###.###-##");
		mascaraCepR = new MaskFormatter("#####-###");
		mascaraEndR = new MaskFormatter("*******************************");
		mascaraNuR = new MaskFormatter("*******************************");
		mascaraCidadeR = new MaskFormatter("****************************");
		mascaraEstadoR = new MaskFormatter("****************************");

		mascaraCod.setPlaceholderCharacter('_');
		mascaraNome.setPlaceholderCharacter(' ');
		mascaraCNPJ.setPlaceholderCharacter('_');
		mascaraIns.setPlaceholderCharacter('_');
		mascaraEmailP.setPlaceholderCharacter(' ');
		mascaraEmailC.setPlaceholderCharacter(' ');
		mascaraTelF.setPlaceholderCharacter('_');
		mascaraTelW.setPlaceholderCharacter('_');
		mascaraCep.setPlaceholderCharacter('_');
		mascaraEnd.setPlaceholderCharacter(' ');
		mascaraNu.setPlaceholderCharacter('_');
		mascaraCidade.setPlaceholderCharacter(' ');
		mascaraEstado.setPlaceholderCharacter(' ');
		
		mascaraNomeR.setPlaceholderCharacter(' ');
		mascaraCPF.setPlaceholderCharacter('_');
		mascaraCepR.setPlaceholderCharacter('_');
		mascaraEndR.setPlaceholderCharacter(' ');
		mascaraNuR.setPlaceholderCharacter('_');
		mascaraCidadeR.setPlaceholderCharacter(' ');
		mascaraEstadoR.setPlaceholderCharacter(' ');

	}
	catch(ParseException excp){}	
		Cod = new JTextField(6);
		Nome = new JTextField(100);
		CNPJ = new JTextField(14);
		Ins = new JTextField(12);
		EmailP = new JTextField(40);
		EmailC = new JTextField(40);
		TelF = new JTextField(12);
		TelW = new JTextField(12);
		Cep = new JTextField(8);
		End = new JTextField(80);
		Nu = new JTextField(10);
		Cidade = new JTextField(30);
		Estado = new JTextField(20);
		
		NomeR = new JTextField(50);
		CPF = new JTextField(11);
		CepR = new JTextField(8);
		EndR = new JTextField(80);
		NuR = new JTextField(10);
		CidadeR = new JTextField(30);
		EstadoR = new JTextField(20);
		Descri = new JTextField(200);
		
		Cod.setBounds(225,80,41,20);
		Nome.setBounds(565,80,200,20);
		CNPJ.setBounds(225,120,117,20);
		Ins.setBounds(565,120,110,20);
		EmailP.setBounds(225,160,200,20);
		EmailC.setBounds(565,160,200,20);
		TelF.setBounds(225,200,88,20);
		TelW.setBounds(565,200,98,20);
		Cep.setBounds(225,240,67,20);
		End.setBounds(565,240,200,20);
		Nu.setBounds(795,240,41,20);
		Cidade.setBounds(225,280,120,20);
		Estado.setBounds(565,280,100,20);
		
		NomeR.setBounds(225,380,200,20);
		CPF.setBounds(565,380,95,20);
		CepR.setBounds(225,420,67,20);
		EndR.setBounds(565,420,200,20);
		NuR.setBounds(795,420,41,20);
		CidadeR.setBounds(225,460,120,20);
		EstadoR.setBounds(565,460,100,20);
		Descri.setBounds(225,500,615,100);
		

		tela.add(DE);
		tela.add(DR);
		tela.add(rotuloCod);
		tela.add(rotuloNome);
		tela.add(rotuloCNPJ);
		tela.add(rotuloIns);
		tela.add(rotuloEmailP);
		tela.add(rotuloEmailC);
		tela.add(rotuloTelF);
		tela.add(rotuloTelW);
		tela.add(rotuloCep);
		tela.add(rotuloEnd);
		tela.add(rotuloNu);
		tela.add(rotuloCidade);
		tela.add(rotuloEstado);
		
		tela.add(rotuloNomeR);
		tela.add(rotuloCPF);
		tela.add(rotuloCepR);
		tela.add(rotuloEndR);
		tela.add(rotuloNuR);
		tela.add(rotuloCidadeR);
		tela.add(rotuloEstadoR);
		tela.add(rotuloDesc);

		tela.add(Cod);
		tela.add(Nome);
		tela.add(CNPJ);
		tela.add(Ins);
		tela.add(EmailP);
		tela.add(EmailC);
		tela.add(TelF);
		tela.add(TelW);
		tela.add(Cep);
		tela.add(End);
		tela.add(Nu);
		tela.add(Cidade);
		tela.add(Estado);
		
		tela.add(NomeR);
		tela.add(CPF);
		tela.add(CepR);
		tela.add(EndR);
		tela.add(NuR);
		tela.add(CidadeR);
		tela.add(EstadoR);
		tela.add(Descri);
		
		
			
			btGravar = new JButton();
  			btGravar.setText("Gravar");
           	btGravar.setBounds(80,622,100,30);
           	btGravar.setSize(100,25);
           	btGravar.setBackground(new Color(27,75,153));
			btGravar.setForeground(Color.white);
			btGravar.setFont(new Font("Tahoma",Font.BOLD,14));
			btGravar.addActionListener(this);
			tela.add(btGravar);
            
            btAlterar = new JButton();
  			btAlterar.setText("Alterar");
           	btAlterar.setBounds(215,622,100,30);
           	btAlterar.setSize(100,25);
           	btAlterar.setBackground(new Color(27,75,153));
			btAlterar.setForeground(Color.white);
			btAlterar.setFont(new Font("Tahoma",Font.BOLD,14));
			btAlterar.addActionListener(this);
            tela.add(btAlterar);
            
            btExcluir = new JButton();
  			btExcluir.setText("Excluir");
           	btExcluir.setBounds(350,622,100,30);
           	btExcluir.setSize(100,25);
           	btExcluir.setBackground(new Color(27,75,153));
			btExcluir.setForeground(Color.white);
			btExcluir.setFont(new Font("Tahoma",Font.BOLD,14));
			btExcluir.addActionListener(this);
            tela.add(btExcluir);
            
            btlocalizar = new JButton();
  			btlocalizar.setText("Localizar");
           	btlocalizar.setBounds(485,622,100,30);
           	btlocalizar.setSize(100,25);
           	btlocalizar.setBackground(new Color(27,75,153));
			btlocalizar.setForeground(Color.white);
			btlocalizar.setFont(new Font("Tahoma",Font.BOLD,14));
			btlocalizar.addActionListener(this);
            tela.add(btlocalizar);
            
            btNovo = new JButton();
  			btNovo.setText("Novo");
           	btNovo.setBounds(620,622,100,30);
           	btNovo.setSize(100,25);
           	btNovo.setBackground(new Color(27,75,153));
			btNovo.setForeground(Color.white);
			btNovo.setFont(new Font("Tahoma",Font.BOLD,14));
			btNovo.addActionListener(this);
            tela.add(btNovo);
                                    
            btCancelar = new JButton();
  			btCancelar.setText("Cancelar");
           	btCancelar.setBounds(755,622,100,30);
           	btCancelar.setSize(100,25);
           	btCancelar.setBackground(new Color(27,75,153));
			btCancelar.setForeground(Color.white);
			btCancelar.setFont(new Font("Tahoma",Font.BOLD,14));
			btCancelar.addActionListener(this);
            tela.add(btCancelar);
            
            
            setBotoes(true,true,false,false,false,false);
            
        caixa1 = new JScrollPane(null);
		caixa1.setBounds(80,70,780,250);
		tela.add(caixa1);
		
		caixa2 = new JScrollPane(null);
		caixa2.setBounds(80,370,780,240);
		tela.add(caixa2);
        


		setResizable(false);
		setSize(920,700);
		setLocationRelativeTo(null);
	
		carregaResultSet();
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
	
	String sql="INSERT INTO cadastrocnpj(Cod,Nome,CNPJ,"+"Ins,EmailP,EmailC,TelF,TelW,Cep,End,Nu,Cidade,Estado,NomeR,CPF,CepR,EndR,NuR,CidadeR,EstadoR,Descri)Values('"+
		Cod.getText()+"','"+
		Nome.getText()+"','"+
		CNPJ.getText()+"','"+
		Ins.getText()+"','"+
		EmailP.getText()+"','"+
		EmailC.getText()+"','"+
		TelF.getText()+"','"+
		TelW.getText()+"','"+
		Cep.getText()+"','"+
		End.getText()+"','"+
		Nu.getText()+"','"+
		Cidade.getText()+"','"+
		Estado.getText()+"','"+
		NomeR.getText()+"','"+
		CPF.getText()+"','"+
		CepR.getText()+"','"+
		EndR.getText()+"','"+
		NuR.getText()+"','"+
		CidadeR.getText()+"','"+
		EstadoR.getText()+"','"+
		Descri.getText()+"')";
		
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
			String sql = "UPDATE cadastrocnpj SET " +
			
		"Cod ='"+ Cod.getText()+"',"+
		"Nome = '"+ Nome.getText()+"',"+
		"CNPJ ='"+ CNPJ.getText()+"',"+
		"Ins ='"+ Ins.getText()+"',"+
		"EmailP ='"+ EmailP.getText()+"',"+
		"EmailC ='"+ EmailC.getText()+"',"+
		"TelF ='"+ TelF.getText()+"',"+
		"TelW ='"+ TelW.getText()+"',"+
		"CEP ='"+ Cep.getText()+"',"+
		"End ='"+ End.getText()+"',"+
		"Nu ='"+ Nu.getText()+"',"+
		"Cidade ='"+ Cidade.getText()+"',"+
		"Estado ='"+ Estado.getText()+"',"+
		"NomeR ='"+ NomeR.getText()+"',"+
		"CPF ='"+ CPF.getText()+"',"+
		"CepR ='"+ CepR.getText()+"',"+
		"EndR ='"+ EndR.getText()+"',"+
		"NuR ='"+ NuR.getText()+"',"+
		"CidadeR ='"+ CidadeR.getText()+"',"+
		"EstadoR ='"+ EstadoR.getText()+"',"+
		"Descri ='"+Descri.getText()+"'"+
		"WHERE Cod ='"+ Cod.getText()+"'";
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
				String sql="SELECT Cod, Nome FROM cadastrocnpj Where Cod ='" +Cod.getText()+"'";
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
						sql="DELETE FROM cadastrocnpj Where Cod ='"+Cod.getText()+"'";
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
						
						
		if(e.getSource()==btlocalizar || e.getSource()==Cod)
						{
							try
								{
								String sql ="SELECT * FROM cadastrocnpj Where Cod ='" +Cod.getText()+"'";
								
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
	String url="jdbc:mysql://127.0.0.1:3306/afsistemadb";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection minhaConexao=DriverManager.getConnection(url,"root","");
			statement=minhaConexao.createStatement(resultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);;
			resultSet=statement.executeQuery("SELECT * FROM cadastrocnpj");
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
						CNPJ.setText("");
						Ins.setText("");
						EmailP.setText("");
						EmailC.setText("");
						TelF.setText("");
						TelW.setText("");
						Cep.setText("");
						End.setText("");
						Nu.setText("");
						Cidade.setText("");
						Estado.setText("");
						NomeR.setText("");
						CPF.setText("");
						CepR.setText("");
						EndR.setText("");
						NuR.setText("");
						CidadeR.setText("");
						EstadoR.setText("");
						Descri.setText("");
			}

public void atualizaCampos()
{
try
{
	
						Cod.setText(resultSet.getString("Cod"));
						Nome.setText(resultSet.getString("Nome"));
						CNPJ.setText(resultSet.getString("CNPJ"));
						Ins.setText(resultSet.getString("Ins"));
						EmailP.setText(resultSet.getString("EmailP"));
						EmailC.setText(resultSet.getString("EmailC"));
						TelF.setText(resultSet.getString("TelF"));
						TelW.setText(resultSet.getString("TelW"));
						Cep.setText(resultSet.getString("Cep"));
						End.setText(resultSet.getString("End"));
						Nu.setText(resultSet.getString("Nu"));
						Cidade.setText(resultSet.getString("Cidade"));
						Estado.setText(resultSet.getString("Estado"));
						NomeR.setText(resultSet.getString("NomeR"));
						CPF.setText(resultSet.getString("CPF"));
						CepR.setText(resultSet.getString("CepR"));
						EndR.setText(resultSet.getString("EndR"));
						NuR.setText(resultSet.getString("NuR"));
						CidadeR.setText(resultSet.getString("CidadeR"));
						EstadoR.setText(resultSet.getString("EstadoR"));
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
