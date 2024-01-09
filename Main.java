import java.text.DecimalFormat; 

public class Main{
    //Método main
    public static void main(String[] args){
        
         //Imprime título do programa + ASCII
        System.out.println("      ⠀⠀⢀⣠⣿⣧⣀⠀⠀⠀                  ⠀⠀⢀⣠⣿⣧⣀⠀⠀⠀");
        System.out.println("⠀    ⠀⠀⢠⣿⠿⣿⡟⢿⣷⡄⠀⠀          ⠀    ⠀⠀⢠⣿⠿⣿⡟⢿⣷⡄⠀");
        System.out.println("⠀   ⠀⠀⠀⠸⣿⣦⣿⡇⠀⠛⠋⠀           ⠀   ⠀⠀⠀⠸⣿⣦⣿⡇⠀⠛⠋⠀");
        System.out.println("    ⠀⠀⠀⠀⠙⠻⣿⣿⣿⣦⡀⠀     Tele Sena  ⠀⠀⠀⠀⠙⠻⣿⣿⣿⣦⡀ ");
        System.out.println("    ⠀⠀⠀⣤⡀⠀⣿⡇⢈⣿⡷⠀               ⠀⠀⠀⣤⡀⠀⣿⡇ ⢈⣿⡷⠀");
        System.out.println("      ⠀⠀⢻⣿⣶⣿⣷⣾⡿⠁⠀                ⠀⠀⢻⣿⣶⣿⣷⣾⡿⠁");
        System.out.println("      ⠀⠀⠈⠙⣿⡏⠁⠀⠀                  ⠀⠀ ⠈⠙⣿⡏⠁⠀⠀\n\n");

        //Cria a variável do formato dos valores
        DecimalFormat formato = new DecimalFormat("#.00");
        //Cria a tele sena e realiza o sorteio
        ControleTeleSena tele1 = new ControleTeleSena();
        tele1.realizaSorteio();
        
        //Tempo...
        try {
            Thread.sleep(1000);
        } catch(Exception e){}
        
        //Imprime dados da edição da tele sena
        System.out.println("\n $ Dados desta edição da Tele Sena:");
        System.out.println(" - Quantidade de tele senas vendidas: " + tele1.getTotalDeTeleSenasVendidas());
        System.out.println(" - Premiação total: R$ " + formato.format(tele1.getValorDoPremio()));
        System.out.println(" - Lucro total obtido: R$ " + formato.format(tele1.getValorDoLucro()));
    }
}