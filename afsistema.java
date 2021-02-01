import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.text.DecimalFormat;
import javax.swing.Timer;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


class afsistema extends JFrame implements ActionListener
{
	JPopupMenu mpopup, mpoupup;
	JMenu menu_Cadastro, menu_Ativa, menu_Relatorio, sub_menu, func, Login;
	//cria menu principal//
		JMenuItem funcadastro,User,logoff,cpf1,cnpj1,relcpf,relcnpj,sub_CadCpf,sub_CadCnpj, sub_CadProduto,sub_Ativa,Relatorio_Cnpj,Relatorio_Cpf,Relatorio_Venda,gerar_pedido,relpedido;
		//cria os submenus//
			JMenuBar menu_Bar1;
			//cria barra de menus//
			JLabel bcliente, bproduto, brelatorio, busuario, img_fundo; ImageIcon icone = new ImageIcon("logo.png");
			//fundo//
			JButton Cliente, Produto, Relatorio, Usuario;
			//botoes//
			JPanel p1;
			JTextField t1,t2;
			
			private JLabel statusBar;
				int ds,dia,mes,ano;
				Calendar data;
				String diasemana[]={"Domingo","Segunda-Feira","terça-Feira","Quarta-Feira","Quinta-Feira","Sexta-Feira","Sabado"};
				String meses[]={"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
				//data//

public static void main(String args[])
{
		JFrame janela = new afsistema();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);

}
	afsistema()
	{
		setTitle("AF-Sistema");
		setBounds(10,10,1200,800);
		setLocationRelativeTo(null);
		img_fundo= new JLabel(icone);
		getContentPane().add(img_fundo);
		ImageIcon icone = new ImageIcon("logo.png");
		setIconImage(icone.getImage());
		img_fundo.setBounds(20,80,1080,500);
		setResizable(true);
		getContentPane().setBackground(new Color(27,75,153));

		data = Calendar.getInstance();
		ds = data.get(Calendar.DAY_OF_WEEK);
		dia = data.get(Calendar.DAY_OF_MONTH);
		mes = data.get(Calendar.MONTH);
		ano = data.get(Calendar.YEAR);
		
		statusBar = new JLabel("Barretos, Hoje é: "+diasemana[ds-1]+", "+dia+" de "+meses[mes]+" de "+ano);
		add(statusBar,BorderLayout.SOUTH);
		statusBar.setForeground(Color.white);
		statusBar.setBounds(10,700,315,50);
		//Menu Inicial
		menu_Bar1=new JMenuBar();
		menu_Cadastro=new JMenu("Cadastro");
		menu_Relatorio=new JMenu("Relatório");
		menu_Ativa=new JMenu("Pedido");
		func=new JMenu("Outros");
		Login=new JMenu("Login");
		sub_menu = new  JMenu ( "Cliente" );


		//Menu de Cadastro
		sub_CadCnpj=new JMenuItem("CNPJ",new ImageIcon("af."));
		sub_CadCnpj.addActionListener(this);
		sub_CadCnpj.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.ALT_MASK));
		sub_CadCnpj.setMnemonic(KeyEvent.VK_N);

		sub_CadCpf=new JMenuItem("CPF",new ImageIcon("af."));
		sub_CadCpf.addActionListener(this);
		sub_CadCpf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.ALT_MASK));
		sub_CadCpf.setMnemonic(KeyEvent.VK_F);

		sub_CadProduto=new JMenuItem("Produto",new ImageIcon("xxxx.gif"));
		sub_CadProduto.addActionListener(this);
		sub_CadProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.ALT_MASK));
		sub_CadProduto.setMnemonic(KeyEvent.VK_P);


		menu_Cadastro.add(sub_menu);
		sub_menu.add(sub_CadCnpj);
		sub_menu.add(sub_CadCpf);
		menu_Cadastro.add(sub_CadProduto);



		//Menu de Relatorio

		Relatorio_Cnpj=new JMenuItem("Cliente Cnpj",new ImageIcon("af."));
		Relatorio_Cnpj.addActionListener(this);
		Relatorio_Cnpj.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.ALT_MASK));
		Relatorio_Cnpj.setMnemonic(KeyEvent.VK_L);

		Relatorio_Cpf=new JMenuItem("Cliente Cpf",new ImageIcon("af."));
		Relatorio_Cpf.addActionListener(this);
		Relatorio_Cpf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.ALT_MASK));
		Relatorio_Cpf.setMnemonic(KeyEvent.VK_T);


		Relatorio_Venda=new JMenuItem("Produtos",new ImageIcon("af."));
		Relatorio_Venda.addActionListener(this);
		Relatorio_Venda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.ALT_MASK));
		Relatorio_Venda.setMnemonic(KeyEvent.VK_O);


		menu_Relatorio.add(Relatorio_Cnpj);
		menu_Relatorio.add(Relatorio_Cpf);
		menu_Relatorio.add(Relatorio_Venda);
		
		//pedido
		gerar_pedido=new JMenuItem("Gerar Pedido",new ImageIcon("af."));
		gerar_pedido.addActionListener(this);
		gerar_pedido.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.ALT_MASK));
		gerar_pedido.setMnemonic(KeyEvent.VK_G);

		relpedido=new JMenuItem("Relatorio Pedido",new ImageIcon("af."));
		relpedido.addActionListener(this);
		relpedido.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.ALT_MASK));
		relpedido.setMnemonic(KeyEvent.VK_R);
		
		menu_Ativa.add(gerar_pedido);
		menu_Ativa.add(relpedido);
		
		
		//funcionario cadastrados
		funcadastro=new JMenuItem("Usuarios",new ImageIcon("af."));
		funcadastro.addActionListener(this);
		funcadastro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.ALT_MASK));
		funcadastro.setMnemonic(KeyEvent.VK_U);
		
		User=new JMenuItem("Cadastro Usuario",new ImageIcon("af."));
		User.addActionListener(this);
		User.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.ALT_MASK));
		User.setMnemonic(KeyEvent.VK_D);
		
		
		func.add(funcadastro);
		func.add(User);
		//login
		logoff=new JMenuItem("LOGOFF",new ImageIcon("logoff.png"));
		logoff.addActionListener(this);
		logoff.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.ALT_MASK));
		logoff.setMnemonic(KeyEvent.VK_F);
		
		Login.add(logoff);
		
		//atalhos
		Cliente = new JButton(new ImageIcon("cliente.png"));
		bcliente = new JLabel("Cliente");
		Cliente.setBounds(1020,20,32,32);
		bcliente.setBounds(1060,18,120,40);
		Cliente.setBackground(new Color(27,75,153));
		bcliente.setForeground(new java.awt.Color(229,229,229));
		getContentPane().add(Cliente);
		getContentPane().add(bcliente);
		Cliente.addActionListener(this);
		Cliente.setBorder(null);
		bcliente.setBorder(null);
		
		t1=new JTextField();
		mpopup = new JPopupMenu();
		MouseListener registra = new MostraPopup();
		Cliente.addMouseListener(registra);
		cnpj1=new JMenuItem("CNPJ");
		cnpj1.addActionListener(this);
		cnpj1.setMnemonic(KeyEvent.VK_C);
		cpf1=new JMenuItem("CPF");
		cpf1.addActionListener(this);
		cpf1.setMnemonic(KeyEvent.VK_P);
		mpopup.add(cnpj1);
		mpopup.add(cpf1);
		getContentPane().add(t1);
		
		Produto = new JButton(new ImageIcon("Produto.png"));
		bproduto = new JLabel("Produto");
		Produto.setBounds(1020,60,32,32);
		bproduto.setBounds(1060,58,120,40);
		Produto.setBackground(new Color(27,75,153));
		bproduto.setForeground(new java.awt.Color(229,229,229));
		getContentPane().add(Produto);
		getContentPane().add(bproduto);
		Produto.addActionListener(this);
		Produto.setBorder(null);
		bproduto.setBorder(null);
		
		Relatorio = new JButton(new ImageIcon("Relatorio.png"));
		brelatorio = new JLabel("Relatorio");
		Relatorio.setBounds(1020,100,32,32);
		brelatorio.setBounds(1060,98,120,40);
		Relatorio.setBackground(new Color(27,75,153));
		brelatorio.setForeground(new java.awt.Color(229,229,229));
		getContentPane().add(Relatorio);
		getContentPane().add(brelatorio);
		Relatorio.addActionListener(this);
		Relatorio.setBorder(null);
		brelatorio.setBorder(null);
		
		t2=new JTextField();
		mpoupup = new JPopupMenu();
		MouseListener registra1 = new MostraPopup();
		Relatorio.addMouseListener(registra1);
		relcnpj=new JMenuItem("CNPJ");
		relcnpj.addActionListener(this);
		relcnpj.setMnemonic(KeyEvent.VK_N);
		relcpf=new JMenuItem("CPF");
		relcpf.addActionListener(this);
		relcpf.setMnemonic(KeyEvent.VK_F);
		mpoupup.add(relcnpj);
		mpoupup.add(relcpf);
		getContentPane().add(t2);
		
		Usuario = new JButton(new ImageIcon("user1.png"));
		busuario = new JLabel("Usuarios");
		Usuario.setBounds(1020,140,32,32);
		busuario.setBounds(1060,138,120,40);
		Usuario.setBackground(new Color(27,75,153));
		busuario.setForeground(new java.awt.Color(229,229,229));
		getContentPane().add(Usuario);
		getContentPane().add(busuario);
		Usuario.addActionListener(this);
		Usuario.setBorder(null);
		busuario.setBorder(null);
		
		

 		setLayout(null);
		menu_Bar1.add(menu_Cadastro);
		menu_Bar1.add(menu_Relatorio);
		menu_Bar1.add(menu_Ativa);
		menu_Bar1.add(func);
		menu_Bar1.add(Login);
		setJMenuBar(menu_Bar1);
	}

	public void actionPerformed(ActionEvent e)
		{
					if(e.getSource()==sub_CadCnpj)
					{
						//instanciar
					cadastro_cnpj janela = new cadastro_cnpj();
						// apresentar
						janela.setVisible(true);

					}
					if(e.getSource()==sub_CadCpf)
					{
						//instanciar
					cadastro_cpf janela = new cadastro_cpf();
						// apresentar
						janela.setVisible(true);

					}
					if(e.getSource()==cnpj1)
					
					{
						//instanciar
						cadastro_cnpj janela = new cadastro_cnpj();
						// apresentar
						janela.setVisible(true);
					}
					if(e.getSource()==cpf1)
					
					{
						//instanciar
						cadastro_cpf janela = new cadastro_cpf();
						// apresentar
						janela.setVisible(true);
					}
					if(e.getSource()==sub_CadProduto)
					{
						//instanciar
					cadastro_produto janela = new cadastro_produto();
						// apresentar
						janela.setVisible(true);

					}
					
					if(e.getSource()==Produto)
					{
						//instanciar
					cadastro_produto janela = new cadastro_produto();
						// apresentar
						janela.setVisible(true);

					}
					if(e.getSource()==Relatorio_Venda)
					{
						//instanciar
					relatorio_prod janela = new relatorio_prod();
						// apresentar
						janela.setVisible(true);

					}
					if(e.getSource()== gerar_pedido)
					{
						//instanciar
					MenuPedido janela = new MenuPedido();
						// apresentar
						janela.setVisible(true);

					}
					if(e.getSource()== relpedido)
					{
						//instanciar
					relatorio_pedido janela = new relatorio_pedido();
						// apresentar
						janela.setVisible(true);

					}
					
					if(e.getSource()== Relatorio_Cnpj)
					{
						//instanciar
					relatorio_cnpj janela = new relatorio_cnpj();
						// apresentar
						janela.setVisible(true);

					}
					if(e.getSource()== Relatorio_Cpf)
					{
						//instanciar
					relatorio_cpf janela = new relatorio_cpf();
						// apresentar
						janela.setVisible(true);

					}
					if(e.getSource()== Relatorio_Venda)
					{
						//instanciar
					relatorio_prod janela = new relatorio_prod();
						// apresentar
						janela.setVisible(true);

					}
					
			
					if(e.getSource()==relcnpj)
					
					{
						//instanciar
						relatorio_cnpj janela = new relatorio_cnpj();
						// apresentar
						janela.setVisible(true);
					}
					if(e.getSource()==relcpf)
					
					{
						//instanciar
						relatorio_cpf janela = new relatorio_cpf();
						// apresentar
						janela.setVisible(true);
					}
					
					
					
					if(e.getSource()==funcadastro)
					
					{
						//instanciar
						relatoriousuario janela = new relatoriousuario();
						// apresentar
						janela.setVisible(true);
					}
					if(e.getSource()==Usuario)
					
					{
						//instanciar
						relatoriousuario janela = new relatoriousuario();
						// apresentar
						janela.setVisible(true);
					}
					if(e.getSource()==User)
					
					{
						//instanciar
						cadastro_usuario janela = new cadastro_usuario();
						// apresentar
						janela.setVisible(true);
					}
					if(e.getSource()==logoff)
					
					{
						//instanciar
						Login janela = new Login();
						// apresentar
						janela.setVisible(true);
						dispose();
					}
		}
class MostraPopup extends MouseAdapter
{
	public void mousePressed(MouseEvent e){
		if(e.getButton()!=3){
		mpopup.show(e.getComponent(),e.getX(),e.getY());					
	}
		if(e.getButton()!=1){
		mpoupup.show(e.getComponent(),e.getX(),e.getY());					
	}
	}
}
}