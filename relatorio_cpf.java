import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.*;
import java.util.ArrayList;
import modelo.ModeloTabela;
import factory.ConnectionFactory;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

class relatorio_cpf extends JFrame implements ActionListener{
	PreparedStatement pst; //= null;
	ResultSet rs;// = null;
    Statement stm;// = null;
	
	JButton btCod,btNome,btcpf,btrg,btEmailP,btTelF,btCidade,bar1,bar2,bar3;
	
	ConnectionFactory conecta  = new ConnectionFactory();
		                
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTable jTable1;
	private	Container	
		c;
	
	public static void main (String[] args) {
		JFrame adicionar = new relatorio_cpf();	
		adicionar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adicionar.setVisible(true);
	}
		

	relatorio_cpf(){
		iniciaTabela();
        conecta.conexao();
       	preencherTabela("SELECT * FROM cadastrocpf ORDER BY Cod");
        
		setTitle("Relatório CPF");
		setSize(1100,600);//30,30,735,670
		setLocationRelativeTo(null);
		setResizable(true);//true
		c = getContentPane();
		c.setLayout(null);
                
                
		c.add(jTable1);
		
			btCod = new JButton();
  			btCod.setText("Codigo");
           	btCod.setBounds(50,30,40,20);
           	btCod.setSize(80,20);
           	btCod.setBackground(new Color(27,75,153));
			btCod.setForeground(Color.white);
			btCod.setFont(new Font("Tahoma",Font.BOLD,10));
			c.add(btCod);
            
            btNome = new JButton();
  			btNome.setText("Nome");
           	btNome.setBounds(128,30,100,30);
           	btNome.setSize(220,20);
           	btNome.setBackground(new Color(27,75,153));
			btNome.setForeground(Color.white);
			btNome.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btNome);
            
            btcpf = new JButton();
  			btcpf.setText("CPF");
           	btcpf.setBounds(346,30,100,30);
           	btcpf.setSize(120,20);
           	btcpf.setBackground(new Color(27,75,153));
			btcpf.setForeground(Color.white);
			btcpf.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btcpf);
            
            btrg = new JButton();
  			btrg.setText("RG");
           	btrg.setBounds(465,30,100,30);
           	btrg.setSize(133,20);
           	btrg.setBackground(new Color(27,75,153));
			btrg.setForeground(Color.white);
			btrg.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btrg);
            
            btEmailP = new JButton();
  			btEmailP.setText("Email");
           	btEmailP.setBounds(598,30,100,30);
           	btEmailP.setSize(168,20);
           	btEmailP.setBackground(new Color(27,75,153));
			btEmailP.setForeground(Color.white);
			btEmailP.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btEmailP);
                                    
            btTelF = new JButton();
  			btTelF.setText("Telefone");
           	btTelF.setBounds(765,30,100,30);
           	btTelF.setSize(166,20);
           	btTelF.setBackground(new Color(27,75,153));
			btTelF.setForeground(Color.white);
			btTelF.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btTelF);
            
            btCidade = new JButton();
  			btCidade.setText("Cidade");
           	btCidade.setBounds(930,30,100,30);
           	btCidade.setSize(120,20);
           	btCidade.setBackground(new Color(27,75,153));
			btCidade.setForeground(Color.white);
			btCidade.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btCidade);
            
            bar1 = new JButton();
           	bar1.setBounds(40,30,100,30);
           	bar1.setSize(10,480);
           	bar1.setBackground(new Color(27,75,153));
            c.add(bar1);
            
            bar2 = new JButton();
           	bar2.setBounds(1050,30,100,30);
           	bar2.setSize(10,480);
           	bar2.setBackground(new Color(27,75,153));
            c.add(bar2);
            
            bar3 = new JButton();
           	bar3.setBounds(50,500,100,30);
           	bar3.setSize(1000,10);
           	bar3.setBackground(new Color(27,75,153));
            c.add(bar3);
		
        }
	                          
    private void iniciaTabela() {
		scrollpane = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        
        jTable1.setBounds(50,50,1000,450);//dimensões da tabela 
        
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] { {},{},{},{},{} },
            new String [] { }
        ));
        
        scrollpane.setViewportView(jTable1);
	}
    
	
	 public void preencherTabela(String SQL){
        ArrayList dados = new ArrayList();
        
        String[] Colunas = new String[]{"Cod","Nome","CPF","Ins","EmailP","TelF","Cidade"};

        try{
            conecta.executaSQL(SQL);
            conecta.rs.first();
            do{
                dados.add(new Object[]{conecta.rs.getInt("Cod"),
                						conecta.rs.getString("Nome"),
                						conecta.rs.getString("CPF"),
                						conecta.rs.getString("RG"),
                						conecta.rs.getString("EmailP"),
                						conecta.rs.getString("TelF"),
                						conecta.rs.getString("Cidade")});
            }while(conecta.rs.next());
	}catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao preencher Arraylist: "+ex);
	}
        ModeloTabela modelo  = new ModeloTabela(dados, Colunas);
        jTable1.setModel(modelo);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(199);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(97);
        jTable1.getColumnModel().getColumn(2).setResizable(false);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(112);
        jTable1.getColumnModel().getColumn(3).setResizable(false);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(148);
        jTable1.getColumnModel().getColumn(4).setResizable(false);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(148);
        jTable1.getColumnModel().getColumn(5).setResizable(false);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(98);
        jTable1.getColumnModel().getColumn(6).setResizable(false);
        jTable1.getTableHeader().setReorderingAllowed(true);
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }/**/

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

