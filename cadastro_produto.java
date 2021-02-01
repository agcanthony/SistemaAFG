import java.sql.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.JButton;


//----------------------------------------------------//
public class cadastro_produto extends JFrame implements ActionListener{
	ResultSet resultSet;
	Statement statement;
	
	JLabel 	P,
			rotuloValor,
			rotuloCod,
			rotuloDes,
			rotuloMarca;
			
			
//------------------------------------------------------//
static	JTextField 	Cod,
				Valor,
				Descri,
				Marca;
						
//------------------------------------------------------//


	MaskFormatter 	mascaraCod,
					mascaraDes,
					mascaraMarca;
				
//------------------------------------------------------//


	JButton btGravar,
			btAlterar,
			btExcluir,
			btlocalizar,
			btNovo,
			btCancelar;
			
//------------------------------------------------------//


	JScrollPane caixa;
	
	
//------------------------------------------------------//
public static void main(String args[]){
		JFrame janela = new cadastro_produto();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}

cadastro_produto(){
		super("Cadastro de Produto");
		
		P=new JLabel("Produtos");
		P.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        P.setForeground(new java.awt.Color(100, 10, 0));

		
		Container tela = getContentPane();
		setLayout(null);
		rotuloCod = new JLabel("Código: ");
		rotuloDes = new JLabel("Descrição: ");
		rotuloMarca = new JLabel("Marca: ");
		rotuloValor = new JLabel("Valor: ");
		
		P.setBounds(290,20,200,20);
		rotuloCod.setBounds(100,80,120,40);
		rotuloDes.setBounds(100,120,130,40);
		rotuloMarca.setBounds(100,160,100,40);
		rotuloValor.setBounds(100,200,80,40);

	try{
		mascaraCod =new MaskFormatter("#####");
		mascaraDes =new MaskFormatter("*********************************************");
		mascaraMarca = new MaskFormatter("******************************************");


		mascaraCod.setPlaceholderCharacter('_');
		mascaraDes.setPlaceholderCharacter(' ');
		mascaraMarca.setPlaceholderCharacter(' ');

	}
	catch(ParseException excp){}
		Cod = new JTextField(6);
		Descri = new JTextField(30);
		Marca = new JTextField(15);
		Valor = new JTextField(10);

		Cod.setBounds(180,90,41,20);
		Descri.setBounds(180,130,350,20);
		Marca.setBounds(180,170,117,20);
		Valor.setBounds(180,210,60,20);


		tela.add(rotuloCod);
		tela.add(rotuloDes);
		tela.add(rotuloMarca);
		tela.add(rotuloValor);

		tela.add(P);
		tela.add(Cod);
		tela.add(Descri);
		tela.add(Marca);
		tela.add(Valor);
		
			btGravar = new JButton();
  			btGravar.setText("Gravar");
           	btGravar.setBounds(325,300,100,30);
           	btGravar.setSize(100,25);
           	btGravar.setBackground(new Color(27,75,153));
			btGravar.setForeground(Color.white);
			btGravar.setFont(new Font("Tahoma",Font.BOLD,14));
			btGravar.addActionListener(this);
			tela.add(btGravar);
            
            btAlterar = new JButton();
  			btAlterar.setText("Alterar");
           	btAlterar.setBounds(115,250,100,30);
           	btAlterar.setSize(100,25);
           	btAlterar.setBackground(new Color(27,75,153));
			btAlterar.setForeground(Color.white);
			btAlterar.setFont(new Font("Tahoma",Font.BOLD,14));
			btAlterar.addActionListener(this);
            tela.add(btAlterar);
            
            btExcluir = new JButton();
  			btExcluir.setText("Excluir");
           	btExcluir.setBounds(250,250,100,30);
           	btExcluir.setSize(100,25);
           	btExcluir.setBackground(new Color(27,75,153));
			btExcluir.setForeground(Color.white);
			btExcluir.setFont(new Font("Tahoma",Font.BOLD,14));
			btExcluir.addActionListener(this);
            tela.add(btExcluir);
            
            btlocalizar = new JButton();
  			btlocalizar.setText("Localizar");
           	btlocalizar.setBounds(385,250,100,30);
           	btlocalizar.setSize(100,25);
           	btlocalizar.setBackground(new Color(27,75,153));
			btlocalizar.setForeground(Color.white);
			btlocalizar.setFont(new Font("Tahoma",Font.BOLD,14));
			btlocalizar.addActionListener(this);
            tela.add(btlocalizar);
            
            btNovo = new JButton();
  			btNovo.setText("Novo");
           	btNovo.setBounds(190,300,100,30);
           	btNovo.setSize(100,25);
           	btNovo.setBackground(new Color(27,75,153));
			btNovo.setForeground(Color.white);
			btNovo.setFont(new Font("Tahoma",Font.BOLD,14));
			btNovo.addActionListener(this);
            tela.add(btNovo);
                                    
            btCancelar = new JButton();
  			btCancelar.setText("Cancelar");
           	btCancelar.setBounds(250,350,100,30);
           	btCancelar.setSize(100,25);
           	btCancelar.setBackground(new Color(27,75,153));
			btCancelar.setForeground(Color.white);
			btCancelar.setFont(new Font("Tahoma",Font.BOLD,14));
			btCancelar.addActionListener(this);
            tela.add(btCancelar);
            
            
            setBotoes(true,true,false,false,false,false);
            

		setResizable(false);
		carregaResultSet();
		setSize(620,500);
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
	
	String sql="INSERT INTO cadastroprod(Cod,Produto1,Marca,ValorProduto)Values('"+
		Cod.getText()+"','"+
		Descri.getText()+"','"+
		Marca.getText()+"','"+
		Valor.getText()+"')";
		
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
			String sql = "UPDATE cadastroprod SET " +
			
		"Cod ='"+ Cod.getText()+"',"+
		"Produto1 ='"+ Descri.getText()+"',"+
		"Marca ='"+ Descri.getText()+"',"+
		"ValorProduto ='"+Marca.getText()+"'"+
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
				String sql="SELECT Cod, Descri FROM cadastroprod Where Cod='" +Cod.getText()+"'";
    				resultSet=statement.executeQuery(sql);
				String nome="";
			try 
				{
				resultSet.next(); nome="Deletar o Cadastro: " + resultSet.getString("Descri"); 
					} 
			catch(SQLException exl)
				{
				JOptionPane.showMessageDialog(null, "Cadastrado nao efetuado");
				carregaResultSet(); return; }
				int n = JOptionPane.showConfirmDialog(null,nome,"",JOptionPane.YES_NO_OPTION);
				if (n==JOptionPane.YES_OPTION)
					{
						sql="DELETE FROM cadastroprod Where Cod='"+Cod.getText()+"'";
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
								String sql ="SELECT * FROM cadastroprod Where Cod ='" +Cod.getText()+"'";
								
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
			resultSet=statement.executeQuery("SELECT * FROM cadastroprod");
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
						Descri.setText("");
						Marca.setText("");
						Valor.setText("");
			}

public void atualizaCampos()
{
try
{
	
						Cod.setText(resultSet.getString("Cod"));
						Descri.setText(resultSet.getString("Produto1"));						
						Marca.setText(resultSet.getString("Marca"));
						Valor.setText(resultSet.getString("ValorProduto"));
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