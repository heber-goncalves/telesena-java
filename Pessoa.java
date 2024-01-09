import java.text.DecimalFormat; 

public class Pessoa{
    
    //Atributos da classe
    private String nome;
    private TeleSena[] teleSenas;
    private double premioRecebido;
    
    //Construtor da classe
    public Pessoa(String nome, int qtdeTeleSenasCompradas){
        this.nome = nome;
        this.teleSenas = new TeleSena[qtdeTeleSenasCompradas];
        this.preencheTeleSenasCompradas();
    }
    
    //Getters & setters
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public TeleSena[] getTeleSenas(){
        return this.teleSenas;
    }
    
    public void setTeleSenas(TeleSena[] teleSenas){
        this.teleSenas = teleSenas;
    }
    
    public double getPremioRecebido(){
        return this.premioRecebido;
    }
    
    public void setPremioRecebido(double premioRecebido){
        this.premioRecebido = premioRecebido;
    }
    
    //Preenche as telesenas que foram compradas pela pessoa
    public void preencheTeleSenasCompradas(){
        for(int i = 0; i < teleSenas.length; i++){
            teleSenas[i] = new TeleSena();
        }
    }
    
    //Sobrescrita do toString()
    @Override
    public String toString(){
        DecimalFormat formato = new DecimalFormat("#.00");
        String retorno = "Nome: " + this.getNome();
        retorno += "\n      Quantidade de tele senas compradas: " + this.getTeleSenas().length;
        retorno += "\n      Prêmio recebido: R$ " + formato.format(this.getPremioRecebido());
        return retorno;
    }
}