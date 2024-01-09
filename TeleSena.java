public class TeleSena{
    
    //Atributos da classe
    private final double preco = 10;
    int teleSena1[];
    int teleSena2[];
    
    //Construtor não recebe parâmetros e seta o temanho de cada uma das sequências de cada tele sena em 25 números inteiro, depois chama o método para preenche-las
    public TeleSena(){
        this.teleSena1 = new int[25];
        this.teleSena2 = new int[25];
        this.preencheTeleSenas();
    }
    
    //Getters & setters
    public double getPreco(){
        return this.preco;
    }
    
    public int[] getTeleSena1(){
        return this.teleSena1;
    }
    public void setTeleSena1(int[] teleSena1){
        this.teleSena1 = teleSena1;
    }
    
    public int[] getTeleSena2(){
        return this.teleSena2;
    }
    public void setTeleSena2(int[] teleSena2){
        this.teleSena2 = teleSena2;
    }
    
    //Método preenche os dois arrays de 25 inteiros de cada tele sena com números sorteados entre 1 e 60
    public void preencheTeleSenas(){
        int cont1 = 0;
        int cont2 = 0;
        while(cont1 < 25){
             int temp =  (int)(Math.random() * 60 + 1);
             boolean jaExiste = false;
             for(int i = 0; i < teleSena1.length; i++){
                 if(teleSena1[i] == temp){
                     jaExiste = true;
                 }
             }
             if(jaExiste == false){
                 teleSena1[cont1] = temp;
                 cont1++;
             }
        }
        
        while(cont2 < 25){
             int temp =  (int)(Math.random() * 60 + 1);
             boolean jaExiste = false;
             for(int i = 0; i < teleSena2.length; i++){
                 if(teleSena2[i] == temp){
                     jaExiste = true;
                 }
             }
             if(jaExiste == false){
                 teleSena2[cont2] = temp;
                 cont2++;
             }
        }
    }
    
    //Sobrescrita do toString()
    @Override
    public String toString(){
        String retorno = "";
        retorno += "Preço: " + this.preco;
        
        retorno += "\n\nTele sena 1:";
        for(int i = 0; i < teleSena1.length; i++){
            retorno += "\n - Número " + (i + 1) + ": " + teleSena1[i];
        }
        
        retorno += "\n\nTele sena 2:";
        for(int i = 0; i < teleSena2.length; i++){
            retorno += "\n - Número " + (i + 1) + ": " + teleSena2[i];
        }
        
        return retorno;
    }
}