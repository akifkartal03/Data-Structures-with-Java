package com.Akif;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Implementation of extended Graph Interface.
 * @param <E> Type of vertices
 */
@SuppressWarnings ("unchecked")
public class AdjacencyListMatrix<E> extends AbstractGraphADT<E> {
    /**
     * Head reference of the row vertices.
     */
    private HeadNode<E> rowHead;
    /**
     * Head reference of the column vertices
     */
    private HeadNode<E> columnHead;
    /**
     * number of edges.
     */
    private int size;

    /**
     * Constructor to initialize the graph given information.
     * @param numV number of vertices in the graph
     * @param directed The directed flag
     * @param arr array of vertices
     */
    public AdjacencyListMatrix(int numV, boolean directed,E[] arr) {
        super(numV, directed);
        rowHead = new HeadNode<> (arr[0],0);
        HeadNode<E> temp = rowHead;
        for (int i = 1; i <numV ; i++) {
            temp.headNext = new HeadNode<> (arr[i],i);
            temp=temp.headNext;
        }
        columnHead = new HeadNode<> (arr[0],0);
        HeadNode<E> temp2 = columnHead;
        for (int i = 1; i <numV ; i++) {
            temp2.headNext = new HeadNode<> (arr[i],i);
            temp2=temp2.headNext;
        }
    }

    /**
     * Insert a new edge into the graph if it is not present.
     * @param edge The new edge will be added.
     */
    @Override
    public void insert (Edge<E> edge) {
        insertHelper (edge);//insert
        if (!isDirected ()) {
            //insert other side.
            insertHelper (new Edge<> (edge.getDest (), edge.getSource ()));
        }
    }

    /**
     * Insert a new edge into the graph if it is not present.
     * @param edge The new edge will be added.
     */
    private void insertHelper(Edge<E> edge){
        //find correct row and column positions
        HeadNode<E> rowTemp = getRowHead (edge.getDest ());
        HeadNode<E> columnTemp = getColumnHead (edge.getSource ());
        if (rowTemp!=null && columnTemp!=null){ //if edge is correct
            //make connections and add proper postion
            int column = rowTemp.index;
            int row = columnTemp.index;
            if (rowTemp.edgeNext==null && columnTemp.edgeNext==null && rowItemNumber (row)==-1 && columnItemNumber (column)==-1){
                rowTemp.edgeNext =new EdgeNode<> (edge,row,column);
                columnTemp.edgeNext =rowTemp.edgeNext;
                size++;
            }
            else if (rowTemp.edgeNext==null && columnItemNumber (column)==-1){
                if (columnTemp.edgeNext.column < column){
                    EdgeNode<E> prev = getColumnEdgeNode (row,column);
                    prev.cnext=new EdgeNode<> (edge,row,column,null,null,prev,prev.cnext);
                    rowTemp.edgeNext =prev.cnext;

                }
                else if (columnTemp.edgeNext.column > column){
                    columnTemp.edgeNext = new EdgeNode<> (edge,row,column,null,null,null,columnTemp.edgeNext);
                    columnTemp.edgeNext.cnext.cprev=columnTemp.edgeNext;
                    rowTemp.edgeNext =columnTemp.edgeNext;
                }
                size++;
            }
            else if (columnTemp.edgeNext==null && rowItemNumber (row) ==-1){
                if (rowTemp.edgeNext.row < row){
                    EdgeNode<E> prev = getRowEdgeNode (row,column);
                    prev.rnext=new EdgeNode<> (edge,row,column,prev.rnext,prev,null,null);
                    columnTemp.edgeNext =prev.rnext;
                }
                else if (rowTemp.edgeNext.row > row){
                    rowTemp.edgeNext = new EdgeNode<> (edge,row,column,rowTemp.edgeNext,null,null,null);
                    rowTemp.edgeNext.rnext.rprev=rowTemp.edgeNext;
                    columnTemp.edgeNext =rowTemp.edgeNext;
                }
                size++;
            }
            else{
                EdgeNode<E> node = new EdgeNode<> (edge,row,column);
                if (columnTemp.edgeNext.column < column){
                    EdgeNode<E> prev = getColumnEdgeNode (row,column);
                    node.cprev=prev;
                    node.cnext=prev.cnext;
                    prev.cnext=node;
                    if (node.cnext!=null)
                        node.cnext.cprev=node;
                    size++;
                }
                else if (columnTemp.edgeNext.column > column){
                    node.cnext=columnTemp.edgeNext;
                    columnTemp.edgeNext.cprev=node;
                    columnTemp.edgeNext = node;
                    size++;
                }
                if (rowTemp.edgeNext.row < row){
                    EdgeNode<E> prev = getRowEdgeNode (row,column);
                    node.rnext=prev.rnext;
                    node.rprev=prev;
                    prev.rnext=node;
                }
                else if (rowTemp.edgeNext.row > row){
                    node.rnext=rowTemp.edgeNext;
                    rowTemp.edgeNext.rprev =node;
                    rowTemp.edgeNext = node;
                }
            }
        }
    }

    /**
     * Returns an edge such that it is predecessor edge of edge in given coordinates.
     * It makes row by row search.
     * @param row row coordinate of edge
     * @param column column coordinate of egde
     * @return an edge such that it is predecessor edge of edge in given coordinates.
     */
    private EdgeNode<E> getRowEdgeNode(int row,int column){
        HeadNode<E> rowTemp = getRowIndex (column);
        EdgeNode<E> rowEdgeTemp = rowTemp.edgeNext;
        while (rowEdgeTemp.rnext!=null &&rowEdgeTemp.rnext.row<row){
            rowEdgeTemp=rowEdgeTemp.rnext;
        }
        return rowEdgeTemp;
    }
    /**
     * Returns an edge such that it is predecessor edge of edge in given coordinates.
     * It makes column by row search.
     * @param row row coordinate of edge
     * @param column column coordinate of edge
     * @return an edge such that it is predecessor edge of edge in given coordinates.
     */
    private EdgeNode<E> getColumnEdgeNode(int row ,int column){
        HeadNode<E> columnTemp = getColumnIndex (row);
        EdgeNode<E> columnEdgeTemp = columnTemp.edgeNext;
        while (columnEdgeTemp.cnext!=null &&columnEdgeTemp.cnext.column<column){
            columnEdgeTemp=columnEdgeTemp.cnext;
        }
        return columnEdgeTemp;
    }

    /**
     * Return row node of vertex in given index.
     * @param index row index of vertex
     * @return row node of vertex in given index.
     */
    private HeadNode<E> getRowIndex(int index){
        checkIndex (index);
        HeadNode<E> rowTemp = rowHead;
        for (int i=0; i<index && rowTemp != null; i++) {
            rowTemp = rowTemp.headNext;
        }
        return rowTemp;
    }
    /**
     * Return column node of vertex in given index.
     * @param index column index of vertex
     * @return row column of vertex in given index.
     */
    private HeadNode<E> getColumnIndex(int index){
        checkIndex (index);
        HeadNode<E> columnTemp = columnHead;
        for (int i=0; i<index && columnTemp != null; i++) {
            columnTemp = columnTemp.headNext;
        }
        return columnTemp;
    }

    /**
     * Return row node of given destination vertex
     * @param dest destination vertex
     * @return row node of given destination vertex, if it is present,
     * otherwise null.
     */
    private HeadNode<E> getRowHead(E dest){
        HeadNode<E> rowTemp = rowHead;
        while (rowTemp!=null){
            if (rowTemp.vertex.equals (dest)){ //find dest
               return rowTemp;
            }
            rowTemp = rowTemp.headNext;
        }
        return null;
    }
    /**
     * Return column node of given source vertex
     * @param source source vertex
     * @return column node of given destination vertex if it is present,
     * otherwise null.
     */
    private HeadNode<E> getColumnHead(E source){
        HeadNode<E> columnTemp = columnHead;
        while (columnTemp!=null){
            if (columnTemp.vertex.equals (source)){ //find source
               return columnTemp;
            }
            columnTemp = columnTemp.headNext;
        }
        return null;
    }

    /**
     * Returns row number of head edge node if that head edge has edge with given row number.
     * @param row row number to search.
     * @return row number of head edge node if that head edge has edge with given row number,
     * otherwise -1.
     */
    private int rowItemNumber(int row){
        HeadNode<E> rowTemp = rowHead;
        EdgeNode<E> rowEdgeTemp;
        while (rowTemp!=null){
            rowEdgeTemp = rowTemp.edgeNext;
            while (rowEdgeTemp!=null){ //search given row number
              if (rowEdgeTemp.row==row)
                    return rowTemp.edgeNext.row; //head edge node row number
              rowEdgeTemp=rowEdgeTemp.rnext;
            }
            rowTemp = rowTemp.headNext;
        }
        return -1;
    }
    /**
     * Returns column number of head edge node if that head edge has edge with given column number.
     * @param column column number to search.
     * @return column number of head edge node if that head edge has edge with given column number,
     * otherwise -1.
     */
    private int columnItemNumber(int column){
        HeadNode<E> rowTemp = columnHead;
        EdgeNode<E> rowEdgeTemp;
        while (rowTemp!=null){
            rowEdgeTemp = rowTemp.edgeNext;
            while (rowEdgeTemp!=null){
                if (rowEdgeTemp.column==column)
                    return rowTemp.edgeNext.column;
                rowEdgeTemp=rowEdgeTemp.cnext;
            }
            rowTemp = rowTemp.headNext;
        }
        return -1;
    }

    /**
     * Check given index value with number of vertex.
     * @param index index will be checked.
     */
    private void checkIndex(int index){
        if (index<0 && index>=numV)
            throw new IndexOutOfBoundsException ();
    }
    /** Determine whether an edge exists.
     @param source The source vertex
     @param dest The destination vertex
     @return true if there is an edge from source to dest
     */
    @Override
    public boolean isEdge (E source, E dest) {
        return getEdge (source, dest) != null;
    }
    /** Get the edge between two vertices.
     @param source The source vertex
     @param dest The destination vertex
     @return The Edge between these two vertices
     or null if there is no edge
     */
    @Override
    public Edge<E> getEdge (E source, E dest) {
        HeadNode<E> columnTemp = getColumnHead (source);
        if (columnTemp!=null){
            EdgeNode<E> columnEdgeTemp = columnTemp.edgeNext;
            while (columnEdgeTemp!=null){
                if (columnEdgeTemp.edge.getDest ().equals (dest))
                    return columnEdgeTemp.edge;
                columnEdgeTemp=columnEdgeTemp.cnext;
            }
        }
        return null;
    }

    /**
     * Return edge node given source and destination.
     * @param source source vertex
     * @param dest dest vertex
     * @return edge node given source and destination.if it is present, otherwise null.
     */
    private EdgeNode<E> getEdgeNode(E source, E dest){
        HeadNode<E> columnTemp = getColumnHead (source);
        if (columnTemp!=null){
            EdgeNode<E> columnEdgeTemp = columnTemp.edgeNext;
            while (columnEdgeTemp!=null){
                if (columnEdgeTemp.edge.getDest ().equals (dest))
                    return columnEdgeTemp;
                columnEdgeTemp=columnEdgeTemp.cnext;
            }
        }
        return null;
    }
    /** Return an iterator to the edges connected
     to a given vertex.
     @param source The source vertex
     @return An Iterator to the vertices
     connected to source
     */
    @Override
    public Iterator edgeIterator (E source) {
        return new ListIter (source);
    }
    /**
     * Deletes an individual edge.
     * @param edge an edge will be removed, if it is present.
     */
    @Override
    public void delete (Edge<E> edge) {
        deleteHelper (edge);//delete
        if (!isDirected ()) {
            //delete other side.
            deleteHelper (new Edge<> (edge.getDest (), edge.getSource ()));
        }
    }
    /**
     * Deletes an individual edge.
     * @param edge an edge will be removed, if it is present.
     */
    private void deleteHelper(Edge<E> edge){
        HeadNode<E> columnTemp = getColumnHead (edge.getSource ());
        if (columnTemp!=null){
            EdgeNode<E> columnEdgeTemp = columnTemp.edgeNext;
            while (columnEdgeTemp!=null){
                if (columnEdgeTemp.edge.getDest ().equals (edge.getDest ())){
                    EdgeNode<E> cprev = columnEdgeTemp.cprev;
                    EdgeNode<E> cnext = columnEdgeTemp.cnext;
                    EdgeNode<E> rnext = columnEdgeTemp.rnext;
                    EdgeNode<E> rprev = columnEdgeTemp.rprev;
                    if (cprev!=null)
                        cprev.cnext=cnext;
                    if (cnext!=null)
                        cnext.cprev=cprev;
                    if (rnext!=null)
                        rnext.rprev=rprev;
                    if (rprev!=null)
                        rprev.rnext =rnext;
                    if (cprev==null && cnext==null)
                        columnTemp.edgeNext=null;
                    if (cprev == null && cnext!=null)
                        columnTemp.edgeNext=cnext;
                    HeadNode<E> eHeadNode =getRowHead (edge.getDest ());
                    if (rnext == null && rprev == null){
                        if (eHeadNode!=null)
                            eHeadNode.edgeNext=null;
                    }
                    if (rprev==null && rnext!=null){
                        if (eHeadNode!=null)
                            eHeadNode.edgeNext=rnext;
                    }
                    size--;
                    break;
                }
                columnEdgeTemp=columnEdgeTemp.cnext;
            }
        }
    }
    /**
     * Inserts an individual vertex.
     * @param vertex a vertex will be added if it is not present.
     */
    @Override
    public void insertVertex (E vertex) {
        if (getRowHead (vertex)==null){ //if this vertex is not in the graph
            HeadNode<E> rowTemp = rowHead;
            HeadNode<E> columnTemp = columnHead;
            while (rowTemp.headNext!=null&&columnTemp.headNext!=null){
                columnTemp=columnTemp.headNext;
                rowTemp = rowTemp.headNext;
            }
            rowTemp.headNext=new HeadNode<> (vertex,numV);
            columnTemp.headNext =new HeadNode<> (vertex,numV);
            numV++;
        }
    }
    /**
     * Deletes an individual vertex.
     * Check Report for more information.
     * @param vertex a vertex will be removed, if it is present.
     */
    @Override
    public void deleteVertex (E vertex) {
        HeadNode<E> rowTemp = getRowHead (vertex);
        HeadNode<E> columnTemp = getColumnHead (vertex);
        EdgeNode<E> temp ;
        //first delete all edge that belongs that vertex
        if (rowTemp!=null && columnTemp!=null){
            temp=rowTemp.edgeNext;
            while(temp!=null){
                delete (temp.edge);
                temp=temp.rnext;
            }
            temp=columnTemp.edgeNext;
            while(temp!=null){
                delete (temp.edge);
                temp=temp.cnext;
            }
            //decrement index;
            rowTemp = rowTemp.headNext;
            while (rowTemp!=null){
                rowTemp.index =rowTemp.index-1;
                temp=rowTemp.edgeNext;
                while(temp!=null){
                    temp.column = temp.column-1;
                    temp=temp.rnext;
                }
                rowTemp=rowTemp.headNext;
            }
            columnTemp = columnTemp.headNext;
            while (columnTemp != null){
                columnTemp.index=columnTemp.index-1;
                temp=columnTemp.edgeNext;
                while(temp!=null){
                    temp.row = temp.row-1;
                    temp=temp.cnext;
                }
                columnTemp=columnTemp.headNext;
            }
            rowTemp=rowHead;
            columnTemp=columnHead;
            if (rowTemp.vertex.equals (vertex)){
                rowHead=rowHead.headNext;
            }
            else{
                while (rowTemp.headNext!=null &&!rowTemp.headNext.vertex.equals (vertex)){
                    rowTemp=rowTemp.headNext;
                }
                rowTemp.headNext=rowTemp.headNext.headNext;
            }
            if (columnTemp.vertex.equals (vertex)){
                columnHead=columnHead.headNext;
            }
            else{
                while (columnTemp.headNext!=null &&!columnTemp.headNext.vertex.equals (vertex)){
                    columnTemp=columnTemp.headNext;
                }
                columnTemp.headNext=columnTemp.headNext.headNext;
            }
            numV--;
        }
        else
            throw new IllegalArgumentException ();

    }
    /**
     * Performs Breadth-first search of the graph by starting given vertex.
     * @param startVertex start vertex of search
     * @return The array of parents.if start vertex is present, otherwise null.
     */
    @Override
    public E[] bfs (E startVertex) {
        Queue<E> theQueue = new LinkedList<E> ();
        HeadNode<E> headNode = getColumnHead (startVertex);
        if (headNode!=null){
            int startIndex =headNode.index;
            // Declare array parent and initialize its elements to null.
            E[] parent = (E[])new Object[getNumV ()];
            for (int i = 0; i < getNumV (); i++) {
                parent[i] = null;
            }
            // Declare array identified and
            // initialize its elements to false.
            boolean[] identified = new boolean[getNumV()];
            /* Mark the start vertex as identified and insert it
               into the queue */
            identified[startIndex] = true;
            theQueue.offer(startVertex);
            /* While the queue is not empty */
            while (!theQueue.isEmpty()) {
              /* Take a vertex, current, out of the queue.
               (Begin visiting current). */
                E current = theQueue.remove();
                /* Examine each vertex, neighbor, adjacent to current. */
                Iterator < Edge<E> > itr = edgeIterator(current);
                while (itr.hasNext()) {
                    Edge<E> edge = itr.next();
                    E neighbor = edge.getDest();
                    int neighborIndex = getRowHead (neighbor).index;
                    // If neighbor has not been identified
                    if (!identified[neighborIndex]) {
                        // Mark it identified.
                        identified[neighborIndex] = true;
                        // Place it into the queue.
                        theQueue.offer(neighbor);
                      /* Insert the edge (current, neighbor)
                         into the tree. */
                        parent[neighborIndex] = current;
                    }
                }
                // Finished visiting current.
            }
            return parent;
        }
        else //if vertex is not present
            throw new IllegalArgumentException ();
    }

    /**
     * Returns vertex in the given index from 2D list.
     * @param index index of vertex
     * @return vertex in the given index 2D list.
     */
    public E vertex(int index){
        return getColumnIndex (index).vertex;
    }

    /**
     * Return index of given vertex from 2D list.
     * @param vertex vertex to check
     * @return index of given vertex from 2D list if it is present,
     * otherwise throws IllegalArgumentException.
     */
    public int vertexIndex(E vertex){
        HeadNode<E> headNode = getColumnHead (vertex);
        if (headNode != null){
            return headNode.index;
        }
        else
            throw new IllegalArgumentException ();
    }
    /**
     * Performs Depth-first search of the graph by starting first vertex of the graph.
     * @return Finish order of search.
     */
    @Override
    public E[] dfs () {
        DepthFirstSearch<E> depthFirstSearch = new DepthFirstSearch<> (this);
        int[] arr = depthFirstSearch.getFinishOrder ();
        E[] order = (E[])new Object[getNumV ()];
        for (int i = 0; i < arr.length; i++) {
            order[i] = vertex (arr[i]);
        }
        return order;
    }

    /**
     * Returns number of edges in the graph.
     * @return number of edges in the graph.
     */
    public int getSize () {
        return size;
    }

    /**
     * Prints the all edges in the graph by using cprev reference of the node class.
     */
    public void printCprev(){
        StringBuilder stringBuilder = new StringBuilder ();
        stringBuilder.append ("Edges on the graph by using cprev reference\n");
        for ( int k = 0; k < 45; k++) stringBuilder.append ("-");
        stringBuilder.append ("\n");
        HeadNode<E> rowTemp = columnHead;
        EdgeNode<E> rowEdgeTemp ;
        while (rowTemp!=null){
            rowEdgeTemp = rowTemp.edgeNext;
            while (rowEdgeTemp!=null && rowEdgeTemp.cnext!=null){
                rowEdgeTemp=rowEdgeTemp.cnext;
            }
            while (rowEdgeTemp!=null){
                stringBuilder.append (rowEdgeTemp.edge+ "{"+rowEdgeTemp.row+", "+rowEdgeTemp.column+"}"+"\n");
                rowEdgeTemp=rowEdgeTemp.cprev;
            }
            rowTemp = rowTemp.headNext;
        }
        for ( int k = 0; k < 45; k++) stringBuilder.append ("-");
        stringBuilder.append ("\n");
        System.out.println (stringBuilder);
    }
    /**
     * Prints the all edges in the graph by using rnext reference of the node class.
     */
    public void printRnext(){
        StringBuilder stringBuilder = new StringBuilder ();
        stringBuilder.append ("Edges on the graph by using rnext reference\n");
        for ( int k = 0; k < 45; k++) stringBuilder.append ("-");
        stringBuilder.append ("\n");
        HeadNode<E> rowTemp = rowHead;
        EdgeNode<E> rowEdgeTemp ;
        while (rowTemp!=null){
            rowEdgeTemp = rowTemp.edgeNext;
            while (rowEdgeTemp!=null){
                stringBuilder.append (rowEdgeTemp.edge+ "{"+rowEdgeTemp.row+", "+rowEdgeTemp.column+"}"+"\n");
                rowEdgeTemp=rowEdgeTemp.rnext;
            }
            rowTemp = rowTemp.headNext;
        }
        for ( int k = 0; k < 45; k++) stringBuilder.append ("-");
        stringBuilder.append ("\n");
        System.out.println (stringBuilder);
    }
    /**
     * Prints the all edges in the graph by using rprev reference of the node class.
     */
    public void printRprev(){
        StringBuilder stringBuilder = new StringBuilder ();
        stringBuilder.append ("Edges on the graph by using rprev reference\n");
        for ( int k = 0; k < 45; k++) stringBuilder.append ("-");
        stringBuilder.append ("\n");
        HeadNode<E> rowTemp = rowHead;
        EdgeNode<E> rowEdgeTemp ;
        while (rowTemp!=null){
            rowEdgeTemp = rowTemp.edgeNext;
            while (rowEdgeTemp!=null && rowEdgeTemp.rnext!=null){
                rowEdgeTemp=rowEdgeTemp.rnext;
            }
            while (rowEdgeTemp!=null){
                stringBuilder.append (rowEdgeTemp.edge+ "{"+rowEdgeTemp.row+", "+rowEdgeTemp.column+"}"+"\n");
                rowEdgeTemp=rowEdgeTemp.rprev;
            }
            rowTemp = rowTemp.headNext;
        }
        for ( int k = 0; k < 45; k++) stringBuilder.append ("-");
        stringBuilder.append ("\n");
        System.out.println (stringBuilder);
    }

    /**
     * Returns all edges in the graph by using cnext reference of the node class.
     * @return all edges in the graph by using cnext reference of the node class.
     */
    @Override
    public String toString () {
        StringBuilder stringBuilder = new StringBuilder ();
        stringBuilder.append ("Edges on the graph with row and column index by using cnext reference\n");
        for ( int k = 0; k < 45; k++) stringBuilder.append ("-");
        stringBuilder.append ("\n");
        HeadNode<E> rowTemp = columnHead;
        EdgeNode<E> rowEdgeTemp ;
        while (rowTemp!=null){
            rowEdgeTemp = rowTemp.edgeNext;
            while (rowEdgeTemp!=null){
                stringBuilder.append (rowEdgeTemp.edge+ "{"+rowEdgeTemp.row+", "+rowEdgeTemp.column+"}"+"\n");
                rowEdgeTemp=rowEdgeTemp.cnext;
            }
            rowTemp = rowTemp.headNext;
        }
        for ( int k = 0; k < 45; k++) stringBuilder.append ("-");
        stringBuilder.append ("\n");
        return stringBuilder.toString ();
    }
    public void printGraphRowAndColumn(){
        System.out.println("***Graph Row and Column Head***");
        for (int k = 0; k < 45; k++) System.out.print("-");
        HeadNode<E> rowTemp = rowHead;
        System.out.print ("\n\t\t");
        while (rowTemp!=null){
            System.out.print (rowTemp.vertex+"  ");
            rowTemp = rowTemp.headNext;
        }
        System.out.print ("\n");
        HeadNode<E> columnTemp = columnHead;
        while (columnTemp!=null){
            System.out.println (columnTemp.vertex);
            columnTemp = columnTemp.headNext;
        }
        for ( int k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");
    }
    /**
     * Iterator class for the edges on the graph.
     */
    private class ListIter implements Iterator<Edge<E>>{
        /**
         * source vertex
         */
        private E source;
        /**
         * index of dest vertex
         */
        private int destIndex;

        public ListIter(E source) {
            this.source = source;
            destIndex=-1;
            updateDest ();

        }
        @Override
        public boolean hasNext () {
            return destIndex !=numV;
        }

        @Override
        public Edge<E> next () {
            if (destIndex ==numV)
                throw new NoSuchElementException ();
            Edge<E> eEdge = getEdge (source,getRowIndex (destIndex).vertex);
            updateDest ();
            return eEdge;
        }
        private void updateDest(){
            destIndex++;
            while (destIndex!=numV && getEdge (source,getRowIndex (destIndex).vertex)==null){
                destIndex++;
            }
        }
    }

    /**
     * EgdeNode class to build 2D linked-list representation.
     * It contains edge and references.
     * @param <E> Type of edge.
     */
    protected static class EdgeNode<E>{
        private Edge<E> edge;
        private EdgeNode<E> rprev ;
        private EdgeNode<E> rnext ;
        private EdgeNode<E> cprev ;
        private EdgeNode<E> cnext ;
        private int row; // row index
        private int column; //column index
        public EdgeNode(Edge<E> item,int r,int c){
            edge = item;
            rnext =null;
            rprev=null;
            cprev=null;
            cnext=null;
            row =r;
            column =c;
        }
        public EdgeNode(Edge<E> item,int r,int c,EdgeNode<E> rn ,EdgeNode<E> rp,EdgeNode<E> cp,EdgeNode<E>  cn){
            edge = item;
            rnext =rn;
            rprev=rp;
            cprev=cp;
            cnext=cn;
            row =r;
            column =c;
        }
    }

    /**
     * HeadNode class to build 2D linked-list representation.
     * It contains vertex and references.
     * @param <E> Type of vertices
     */
    protected static class HeadNode<E>{
        private E vertex;
        private EdgeNode<E> edgeNext ; //head reference of edges
        private HeadNode<E> headNext ; //next reference no prev for vertex
        int index;
        public HeadNode(E item,int i){
            vertex=item;
            edgeNext=null;
            headNext =null;
            index =i;
        }
        public HeadNode(E item,int i,EdgeNode<E> eN,HeadNode<E> hN){
            vertex=item;
            edgeNext =eN;
            headNext=hN;
            index =i;
        }

    }
}
