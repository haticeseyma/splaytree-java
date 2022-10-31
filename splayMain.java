import java.util.*;
public class splayMain {
    public static void main(String[] args)
    {            
        Scanner scan = new Scanner(System.in);
     
        splaytree spt = new splaytree(); 
        System.out.println("Splay Ağacı\n");          
        char ch;

        spt.ekle(15);
        spt.ekle(20);
        spt.ekle(89);
        spt.ekle(70);
        spt.ekle(25);
        spt.ekle(30);
        spt.ekle(12);
        spt.ekle(65);
        spt.ekle(54);
        spt.inorder(); 
        System.out.println("");
        
        do    
        {
            System.out.println("\nSplay Agacı işlemleri\n");
            System.out.println("1. ekle ");
            System.out.println("2. sil ");
            System.out.println("3. ara");
            System.out.println("4. Düğümleri say");
            System.out.println("5. Kontrol et yazdır");
            System.out.println("6. Ağacı temizle");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Eklemek istediğiniz değeri giriniz");
                spt.ekle( scan.nextInt() );                     
                break;
            case 2 : 
                System.out.println("Silmek değeri giriniz");
                spt.remove( scan.nextInt() );                     
                break;                          
            case 3 : 
                System.out.println("Aramak istediğiniz değeri giriniz");
                System.out.println("Arama sonucu : "+ spt.search( scan.nextInt() ));
                break;                                          
            case 4 : 
                System.out.println("Düğüm = "+ spt.countNodes());
                break;     
            case 5 : 
                System.out.println("Boş durum = "+ spt.isEmpty());
                break;     
            case 6 : 
                System.out.println("\nAgac temizlendi");
                spt.clear();
                break;        
            default : 
                System.out.println("Yanlış giriş \n ");
                break;   
            }
            /**  Display tree  **/
            System.out.print("\nPost order : ");
            spt.postorder();
            System.out.print("\nPre order : ");
            spt.preorder();
            System.out.print("\nIn order : ");
            spt.inorder(); 
 
            System.out.println("\nDevam etmek istiyormusun ? (Evet y hayır n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
 
}
