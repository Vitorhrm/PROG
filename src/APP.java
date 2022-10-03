import javax.swing.*;
import java.util.*;
public class APP {
	static Vector<Produto> produtos = new Vector <Produto>();

	public static void adicionar(){
		do{
		Produto aux1 = new Produto();
		aux1.setNome(JOptionPane.showInputDialog("Nome do produto: "));
		aux1.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Preco do produto: ")));
		aux1.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Quantidade do produto: ")));
        produtos.add(aux1);

		} while (JOptionPane.showConfirmDialog(null, "Deseja adicionar mais um produto?") == 0);
	}






	public static void comprar(){
		int valor_Total = 0;
		
		
		
		do{
		String aux_nom = JOptionPane.showInputDialog("Nome do produto: ");
		int aux_quant = Integer.parseInt(JOptionPane.showInputDialog("Quantidade do produto: "));
		
		
		
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getNome().equals(aux_nom) & produtos.get(i).getQuantidade() >= aux_quant) {
				produtos.get(i).setQuantidade(produtos.get(i).getQuantidade() - aux_quant);
				valor_Total += aux_quant * produtos.get(i).getPreco();
				JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!");
				}
			else if (!produtos.get(i).getNome().equals(aux_nom) & produtos.get(i).getQuantidade() < aux_quant) {
				JOptionPane.showMessageDialog(null, "Produto nao encontrado ou quantidade insuficiente!");
			}


	
			if(produtos.get(i).getQuantidade() == 0){
				produtos.remove(i);
			
				}
			}
		} while (JOptionPane.showConfirmDialog(null, "Deseja comprar mais um produto?") == 0);
		
		
		int aux_Do = 0;

		do{
			String[] options = {"Pagar Cartão", "Pagar Boleto","Pix","sair"}; 
			
			int x = JOptionPane.showOptionDialog(null, "Valor total da compra: " + valor_Total,
					"Menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			
			
	 
			switch (x) {
				case 0:
					break;
				//Pagar Cartão

				case 1:
					break;
				//pagar boleto

				case 2:
				//pagar pix
					break;
					
				case 3:
					aux_Do = 1;
					break;
				}
			}while(aux_Do==0);
		}






	public static void estoque(){
		String lista = "";
		for(int i=0; i<produtos.size(); i++){	
			lista=lista+"\n " + produtos.get(i).getNome()+ "--Valor: R$" + produtos.get(i).getPreco()+"--Quantidade: " + produtos.get(i).getQuantidade();
		}		

		JOptionPane.showMessageDialog(null, lista);
	}


	    public static void main(String[] args) {
	        int k = 0;
	        System.out.println("Hello World!");
	        
	        do{
				String[] options = {"Fornecedor", "comprar","Listar estoque","Sair"}; 
		        int x = JOptionPane.showOptionDialog(null, "Selecione uma opção: ",
		                "Menu",
		                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		        
		        
		 
		        switch (x) {
		        	case 0:
						adicionar();
						break;


		        	case 1:
						comprar();
					    break;


					case 2:
						estoque();
						break;


		        	case 3:
						k++;
						break;
		        }
		        
		        
			}while(k==0);
	    }
	}

