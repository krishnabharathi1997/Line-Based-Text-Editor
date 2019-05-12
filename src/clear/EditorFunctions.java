/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author KRISHNA
 */
public class EditorFunctions {
    ArrayList<String> list=new ArrayList<String>();
    ArrayList<String> copied=new ArrayList<String>();
    
    Stack<String> stackUndo= new Stack<String>();
    public EditorFunctions()
    {
        stackUndo.push(" ");
    }
    protected ArrayList<String>display(String s)
    {
        list.clear();
        String[] lines =s.split("\\r?\\n");
        list.addAll(Arrays.asList(lines));
        return list;
    }
    protected ArrayList<String> display(int n,int m)
    {
        ArrayList<String> selected=new ArrayList<String>(); 
        for(int i=n-1;i<m;i++)
        {
            selected.add(list.get(i));
        }
        return selected;
    }
    protected ArrayList<String> insert(int n,String s)
    {
       if(n-1>=list.size())
       {
           list.add(s);
       }
       else
       {
           list.add(n-1,s);
       }
       stackUndo.clear();
       stackUndo.push("dd."+n);
       stackUndo.push("i."+n+"."+s);
       return list;
    }
    protected ArrayList<String> delete(int n)
    {
        stackUndo.clear();
        stackUndo.push("i."+n+"."+list.get(n-1));
        stackUndo.push("dd."+n);
        
        list.remove(n-1);
        return list;
    }
    protected ArrayList<String> delete(int n,int m)
    {

        m=m-n+1;
        for(int i=1;i<=m;i++)
        {
            list.remove(n-1);
            
        }
        ArrayList<String> temp=list;
        return list;
    }
    protected void copyText(int n,int m)
    {
       
        for(int i=n-1;i<m;i++)
        {
            copied.add(list.get(i).toString());
        }
    }
    protected ArrayList<String> paste(int m)
    {

        if(copied.size()>0)
        {
      
            if(m==list.size())
            {
                for(int i=0;i<copied.size();i++)
                {
                    list.add(copied.get(i));
                    m++;
                }
            }
            else if(m<list.size())
            {
                for(int i=0;i<copied.size();i++)
                {
                    list.add(m,copied.get(i));
                    m++;
                }        
            }
            else if(m>list.size())
            {
                int n=list.size();
                while(n<m)
                {
                    list.add(" ");
                    n++;
                }
                list=paste(m);
            }
    
        }
        return list;
        
        
    }
    protected String undo()
    {
        if(stackUndo.size()>1)
        {
            stackUndo.pop();
            String undoString=stackUndo.pop();
            stackUndo.clear();
            return undoString;
        }
        return " ";
    }
  
    
    
    
}
