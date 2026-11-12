
package testandothread;


public class MinhaThread extends Thread{
    private String mensagem;
    private int intervalo;
    
    public MinhaThread(String mensagem, int intervalo) {
        this.mensagem = mensagem;
        this.intervalo = intervalo;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(mensagem);
                Thread.sleep(intervalo);
            }
        } catch (InterruptedException e) {
            // lidar com exception
        }
    }
}
