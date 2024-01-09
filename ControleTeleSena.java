public class ControleTeleSena{
    
    //Atributos da classe
    private Pessoa[] compradores = new Pessoa[20];
    private Pessoa[] ganhadores = new Pessoa[20];
    private int[] sequenciaPremiada = new int[25];
    private int[] teleSenaSorteada;
    private int qtdeGanhadores, totalDeTeleSenasVendidas, quantidadeGanhadores;
    private double valorTotalVendido, valorDoPremio, valorDoLucro;

    //Método construtor (vende as telesenas e calcula os valores)
    public ControleTeleSena(){
        this.qtdeGanhadores = 0;
        this.venderTeleSenas();
        this.teleSenaSorteada = new TeleSena().getTeleSena1();
        this.valorTotalVendido = this.calculaTotalVendido();
        this.valorDoPremio = this.calculaValorDoPremio();
        this.valorDoLucro = this.calculaValorDoLucro();
    }

    //Getters & setters
    public Pessoa[] getCompradores(){
        return this.compradores;
    }
    public void setCompradores(Pessoa[] compradores){
        this.compradores = compradores;
    }

    public int getTotalDeTeleSenasVendidas(){
        return this.totalDeTeleSenasVendidas;  
    }
    public void setTotalDeTeleSenasVendidas(int totalDeTeleSenasVendidas){
        this.totalDeTeleSenasVendidas = totalDeTeleSenasVendidas;
    }

    public double getValorTotalVendido(){
        return this.valorTotalVendido;  
    }
    public void setValorTotalVendido(double valorTotalVendido){
        this.valorTotalVendido = valorTotalVendido;
    }

    public double getValorDoPremio(){
        return this.valorDoPremio;  
    }
    public void setValorDoPremio(double valorDoPremio){
        this.valorDoPremio = valorDoPremio;
    }

    public double getValorDoLucro(){
        return this.valorDoLucro;  
    }
    public void setValorDoLucro(double valorDoLucro){
        this.valorDoLucro = valorDoLucro;
    }

    public int getQuantidadeGanhadores(){
        return this.quantidadeGanhadores;
    }
    public void setQuantidadeGanhadores(int quantidadeGanhadores){
        this.quantidadeGanhadores = quantidadeGanhadores;
    }

    //Método que vende as telesenas da edição (chamado no construtor)
    public void venderTeleSenas(){
        //Array que armazena os números correspondentes aos nomes que já foram sorteados e usados como compradores
        int[] nomesJaInseridos = new int[20];
        //For que, a cada iteração, sorteia a quantidade de tele senas que serão compradas pelo usuário a ser inserido, soma essa quantidade ao total de tele senas vendidas e sorteia o nome
        for(int i = 0; i < compradores.length; i++){
            int qtdeTeleSenasCompradas = (int)(Math.random() * 15 + 1);
            totalDeTeleSenasVendidas += qtdeTeleSenasCompradas;
            boolean confere = true;
            int sorteioNome = 0;
            while(confere == true){
                confere = false;
                sorteioNome = (int)(Math.random() * 20 + 1);
                for(int i2 = 0; i2 < nomesJaInseridos.length; i2++){
                    if(nomesJaInseridos[i2] == sorteioNome){
                        confere = true;
                        break;
                    }
                }
            }
            nomesJaInseridos[i] = sorteioNome;
            String nomeTemp = "";
            if(sorteioNome == 1){
                nomeTemp = "Jurema";
            } else if(sorteioNome == 2){
                nomeTemp = "Cláudio";
            } else if(sorteioNome == 3){
                nomeTemp = "Bruno";
            } else if(sorteioNome == 4){
                nomeTemp = "Lucas";
            } else if(sorteioNome == 5){
                nomeTemp = "Márcia";
            } else if(sorteioNome == 6){
                nomeTemp = "Sandra";
            } else if(sorteioNome == 7){
                nomeTemp = "Roque";
            } else if(sorteioNome == 8){
                nomeTemp = "Mateus";
            } else if(sorteioNome == 9){
                nomeTemp = "Magali";
            } else if(sorteioNome == 10){
                nomeTemp = "Érica";
            } else if(sorteioNome == 11){
                nomeTemp = "Natália";
            } else if(sorteioNome == 12){
                nomeTemp = "John";
            } else if(sorteioNome == 13){
                nomeTemp = "Cleiton";
            } else if(sorteioNome == 14){
                nomeTemp = "Flávio";
            } else if(sorteioNome == 15){
                nomeTemp = "Joana";
            } else if(sorteioNome == 16){
                nomeTemp = "Carol";
            } else if(sorteioNome == 17){
                nomeTemp = "Henrique";
            } else if(sorteioNome == 18){
                nomeTemp = "Júlio";
            } else if(sorteioNome == 19){
                nomeTemp = "Moisés";
            } else if(sorteioNome == 20){
                nomeTemp = "Taylor";
            }

            //Cria uma nova pessoa e insere com os dados sorteados ao array de compradores
            compradores[i] = new Pessoa(nomeTemp, qtdeTeleSenasCompradas);
        }
    }

    //Método que realiza o sorteio e apresenta os dados da edição da tele sena
    public void realizaSorteio(){
        //Loop que funciona enquanto não houver ganhadores
        while(qtdeGanhadores == 0){
            //Itera sobre os 20 participantes
            for(int i = 0; i < 20; i++){
                //Itera sobre a quantidade de tele senas compradas por cada participante
                for(int i2 = 0; i2 < compradores[i].getTeleSenas().length; i2++){
                    //Cria variáveis contadoras
                    int contaNumeroIguais1 = 0;
                    int contaNumeroIguais2 = 0;
                    //Itera sobre a quantidade de números existentes na tele sena e compara com os números da tele sena sorteada
                    for(int i3 = 0; i3 < 25; i3++){
                        for(int i4 = 0; i4 < teleSenaSorteada.length; i4++){
                            if(teleSenaSorteada[i4] == compradores[i].getTeleSenas()[i2].getTeleSena1()[i3]){
                                contaNumeroIguais1 += 1;
                            }
                            if(teleSenaSorteada[i4] == compradores[i].getTeleSenas()[i2].getTeleSena2()[i3]){
                                contaNumeroIguais2 += 1;
                            }
                        }
                    }
                    //Se encontrou ganhador, passa a sequência premiada para o array sequenciaSorteada e adiciona o(s) ganhador(es) ao array de ganhadores
                    if(contaNumeroIguais1 >= 25){
                        for(int sort = 0; sort < 25; sort++){
                            sequenciaPremiada[sort] = compradores[i].getTeleSenas()[i2].getTeleSena1()[sort];
                        }
                        if(ganhadores[qtdeGanhadores] == null){
                            ganhadores[qtdeGanhadores] = compradores[i];
                            qtdeGanhadores += 1;
                        }

                    } else if(contaNumeroIguais2 >= 25){
                        for(int sort = 0; sort < 25; sort++){
                            sequenciaPremiada[sort] = compradores[i].getTeleSenas()[i2].getTeleSena2()[sort];
                        }
                        if(ganhadores[qtdeGanhadores] == null){
                            ganhadores[qtdeGanhadores] = compradores[i];
                            qtdeGanhadores += 1;
                        }
                    }  
                }
            }
            this.sorteiaNovoNumero();
        }
        this.imprimeDados();
    }

    //Caso não tenha tido ganhadores, quando chamado sorteia mais um número
    private void sorteiaNovoNumero(){
        if(qtdeGanhadores == 0){
            int novoNumero = (int)(Math.random() * 60 + 1);
            int contZ = 0;
            while(true){
                for(int z = 0; z < teleSenaSorteada.length; z++){
                    if(novoNumero == teleSenaSorteada[z]){
                        contZ++;
                    }
                }
                if(contZ != 0){
                    novoNumero = (int)(Math.random() * 60 + 1);
                    contZ = 0;
                } else {
                    break;
                }
            }
            int[] teleSenaTemp = new int[teleSenaSorteada.length + 1];
            for(int ii = 0; ii < teleSenaSorteada.length; ii++){
                teleSenaTemp[ii] = teleSenaSorteada[ii];
            }
            teleSenaTemp[teleSenaSorteada.length] = novoNumero;
            teleSenaSorteada = teleSenaTemp;
        }
    }
    
    //Método que imprime os dados após o sorteio
    public void imprimeDados(){
        //Tempo...
        try {
            Thread.sleep(1000);
        } catch(Exception e){}
        //Apresenta todos os números sorteado/tirados no sorteio
        System.out.println(" $ Números sorteados: ");
        //Tempo...
        try {
            Thread.sleep(1000);
        } catch(Exception e){}
        for(int i = 0; i < teleSenaSorteada.length; i++){
            try {
                Thread.sleep(0070);
            } catch(Exception e){}
            if(teleSenaSorteada[i] < 10){
                System.out.print(" ");
            }
            System.out.print(" " + teleSenaSorteada[i] + " |");
            if((i + 1) % 10 == 0){
                System.out.println();
            }
        }
        try {
            Thread.sleep(1000);
        } catch(Exception e){}
        //Apresenta a sequência de números premiada
        System.out.println("\n\n $ Números premiados: ");
        for(int i2 = 0; i2 < sequenciaPremiada.length; i2++){
            if(i2 < 9){
                System.out.print("  #" + (i2 + 1) + ":  " + sequenciaPremiada[i2] + "  ");
                if(sequenciaPremiada[i2] < 10){
                    System.out.print(" ");
                }
            } else{
                System.out.print("  #" + (i2 + 1) + ": " + sequenciaPremiada[i2] + "  ");
                if(sequenciaPremiada[i2] < 10){
                    System.out.print(" ");
                }
            }
            if((i2 + 1) % 5 == 0){
                System.out.println();
            }
        }
        //Tempo...
        try {
            Thread.sleep(1000);
        } catch(Exception e){}
        //Apresenta a lista de ganhadores
        System.out.println("\n $ Ganhadores: ");
        for(int i1 = 0; i1 < ganhadores.length; i1++){
            if(ganhadores[i1] != null){
                try {
                    Thread.sleep(1500);
                } catch(Exception e){}
                ganhadores[i1].setPremioRecebido(this.calculaValorDoPremio()/qtdeGanhadores);
                System.out.println(" - " + (i1 + 1) + ": " + ganhadores[i1]);
                this.quantidadeGanhadores++;
            }
        }
    }

    //Calcula a receita total da edição da Tele Sena
    public double calculaTotalVendido(){
        return this.totalDeTeleSenasVendidas * 10;
    }

    //Calcula o valor total da premiação
    public double calculaValorDoPremio(){
        return (this.valorTotalVendido * 0.80);
    }

    //Calcula o valor do lucro total obtido
    public double calculaValorDoLucro(){
        return (this.valorTotalVendido * 0.20);
    }
}