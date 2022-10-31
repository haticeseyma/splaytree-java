public class splaytree {
    
    private splayNODE kok;
    private int count = 0;

   
    public splaytree()
    {
        kok = null;
    }

    
    public boolean isEmpty()
    {
        return kok == null;
    }

    
    public void clear()
    {
        kok = null;
        count = 0;
    }

    
    public void ekle(int data)
    {
        splayNODE z = kok;
        splayNODE p = null;
        while (z != null)
        {
            p = z;
            if (data > p.data)
                z = z.sag;
            else
                z = z.sol;
        }
        z = new splayNODE();
        z.data = data;
        z.parent = p;
        if (p == null)
            kok = z;
        else if (data > p.data)
            p.sag = z;
        else
            p.sol = z;
        Splay(z);
        count++;
    }
   
    public void makeLeftChildParent(splayNODE c, splayNODE p)
    {
        if ((c == null) || (p == null) || (p.sol != c) || (c.parent != p))
            throw new RuntimeException("WRONG");

        if (p.parent != null)
        {
            if (p == p.parent.sol)
                p.parent.sol = c;
            else 
                p.parent.sag = c;
        }
        if (c.sag != null)
            c.sag.parent = p;

        c.parent = p.parent;
        p.parent = c;
        p.sol = c.sag;
        c.sag = p;
    }

    
    public void makeRightChildParent(splayNODE c, splayNODE p)
    {
        if ((c == null) || (p == null) || (p.sag != c) || (c.parent != p))
            throw new RuntimeException("WRONG");
        if (p.parent != null)
        {
            if (p == p.parent.sol)
                p.parent.sol = c;
            else
                p.parent.sag = c;
        }
        if (c.sol != null)
            c.sol.parent = p;
        c.parent = p.parent;
        p.parent = c;
        p.sag = c.sol;
        c.sol = p;
    }

    
    private void Splay(splayNODE x)
    {
        while (x.parent != null)
        {
            splayNODE Parent = x.parent;
            splayNODE GrandParent = Parent.parent;
            if (GrandParent == null)
            {
                if (x == Parent.sol)
                    makeLeftChildParent(x, Parent);
                else
                    makeRightChildParent(x, Parent);                 
            } 
            else
            {
                if (x == Parent.sol)
                {
                    if (Parent == GrandParent.sol)
                    {
                        makeLeftChildParent(Parent, GrandParent);
                        makeLeftChildParent(x, Parent);
                    }
                    else 
                    {
                        makeLeftChildParent(x, x.parent);
                        makeRightChildParent(x, x.parent);
                    }
                }
                else 
                {
                    if (Parent == GrandParent.sol)
                    {
                        makeRightChildParent(x, x.parent);
                        makeLeftChildParent(x, x.parent);
                    } 
                    else 
                    {
                        makeRightChildParent(Parent, GrandParent);
                        makeRightChildParent(x, Parent);
                    }
                }
            }
        }
        kok = x;
    }

    
    public void remove(int ele)
    {
        splayNODE node = findNode(ele);
       remove(node);
    }

    
    private void remove(splayNODE node)
    {
        if (node == null)
            return;

        Splay(node);
        if( (node.sol != null) && (node.sag !=null))
        { 
            splayNODE min = node.sol;
            while(min.sag!=null)
                min = min.sag;

            min.sag = node.sag;
            node.sag.parent = min;
            node.sol.parent = null;
            kok = node.sol;
        }
        else if (node.sag != null)
        {
            node.sag.parent = null;
            kok = node.sag;
        } 
        else if( node.sol !=null)
        {
            node.sol.parent = null;
            kok = node.sol;
        }
        else
        {
            kok = null;
        }
        node.parent = null;
        node.sol = null;
        node.sag = null;
        node = null;
        count--;
    }

   
    public int countNodes()
    {
        return count;
    }

   
    public boolean search(int val)
    {
        return findNode(val) != null;
    }

    private splayNODE findNode(int data)
    {
        splayNODE PrevNode = null;
        splayNODE z = kok;
        while (z != null)
        {
            PrevNode = z;
            if (data > z.data)
                z = z.sag;
            else if (data < z.data)
                z = z.sol;
            else if(data == z.data) {
                Splay(z);
                return z;
            }

        }
        if(PrevNode != null)
        {
            Splay(PrevNode);
            return null;
        }
        return null;
    }

    
    public void inorder()
    {
        inorder(kok);
    }
    private void inorder(splayNODE r)
    {
        if (r != null)
        {
            inorder(r.sol);
            System.out.print(r.data +" ");
            inorder(r.sag);
        }
    }

   
    public void preorder()
    {
        preorder(kok);
    }
    private void preorder(splayNODE r)
    {
        if (r != null)
        {
            System.out.print(r.data +" ");
            preorder(r.sol);             
            preorder(r.sag);
        }
    }

    
    public void postorder()
    {
        postorder(kok);
    }
    private void postorder(splayNODE r)
    {
        if (r != null)
        {
            postorder(r.sol);             
            postorder(r.sag);
            System.out.print(r.data +" ");
        }
    }     
}



 


