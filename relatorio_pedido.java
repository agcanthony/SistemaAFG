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

class relatorio_pedido extends JFrame implements ActionListener{
	PreparedStatement pst; //= null;
	ResultSet rs;// = null;
    Statement stm;// = null;
	
	JButton btpedido,btcpf,btCNPJ,btprod,btvalor,btdata,bar1,bar2,bar3;
	
	ConnectionFactory conecta  = new ConnectionFactory();
		                
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTable jTable1;
	private	Container	
		c;
	
	public static void main (String[] args) {
		JFrame adicionar = new relatorio_pedido();	
		adicionar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adicionar.setVisible(true);
	}
		

	relatorio_pedido(){
		iniciaTabela();
        conecta.conexao();
       	preencherTabela("SELECT * FROM pedido ORDER BY Pedido");
        
		setTitle("Relatório Pedidos");
		setSize(1100,600);//30,30,735,670
		setLocationRelativeTo(null);
		setResizable(true);//true
		c = getContentPane();
		c.setLayout(null);
                
                
		c.add(jTable1);
		
			btpedido = new JButton();
  			btpedido.setText("Pedido");
           	btpedido.setBounds(50,30,40,20);
           	btpedido.setSize(74,20);
           	btpedido.setBackground(new Color(27,75,153));
			btpedido.setForeground(Color.white);
			btpedido.setFont(new Font("Tahoma",Font.BOLD,10));
			c.add(btpedido);
			
			 btcpf = new JButton();
  			btcpf.setText("CPF");
           	btcpf.setBounds(122,30,100,30);
           	btcpf.setSize(195,20);
           	btcpf.setBackground(new Color(27,75,153));
			btcpf.setForeground(Color.white);
			btcpf.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btcpf);
            
            btCNPJ = new JButton();
  			btCNPJ.setText("CNPJ");
           	btCNPJ.setBounds(315,30,100,30);
           	btCNPJ.setSize(194,20);
           	btCNPJ.setBackground(new Color(27,75,153));
			btCNPJ.setForeground(Color.white);
			btCNPJ.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btCNPJ);
            
            btprod = new JButton();
  			btprod.setText("PRODUTO");
           	btprod.setBounds(508,30,100,30);
           	btprod.setSize(355,20);
           	btprod.setBackground(new Color(27,75,153));
			btprod.setForeground(Color.white);
			btprod.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btprod);
            
            btvalor = new JButton();
  			btvalor.setText("Valor");
           	btvalor.setBounds(862,30,100,30);
           	btvalor.setSize(94,20);
           	btvalor.setBackground(new Color(27,75,153));
			btvalor.setForeground(Color.white);
			btvalor.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btvalor);
            
            btdata = new JButton();
  			btdata.setText("Data");
           	btdata.setBounds(955,30,100,30);
           	btdata.setSize(95,20);
           	btdata.setBackground(new Color(27,75,153));
			btdata.setForeground(Color.white);
			btdata.setFont(new Font("Tahoma",Font.BOLD,10));
            c.add(btdata);
            
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
        
        String[] Colunas = new String[]{"Pedido","CPF","CNPJ","Produto1","ValorProduto","DataPed"};

        try{
            conecta.executaSQL(SQL);
            conecta.rs.first();
            do{
                dados.add(new Object[]{conecta.rs.getInt("Pedido"),
                						conecta.rs.getString("CPF"),                				
                						conecta.rs.getString("CNPJ"),
                						conecta.rs.getString("Produto1"),
                						conecta.rs.getString("ValorProduto"),
                						conecta.rs.getString("DataPed")});
            }while(conecta.rs.next());
	}catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao preencher Arraylist: "+ex);
	}
        ModeloTabela modelo  = new ModeloTabela(dados, Colunas);
        jTable1.setModel(modelo);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(140);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTable1.getColumnModel().getColumn(2).setResizable(false);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(3).setResizable(false);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(4).setResizable(false);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(5).setResizable(false);        
        jTable1.getTableHeader().setReorderingAllowed(true);
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }/**/

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

