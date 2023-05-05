package com.springmvc.domain;

import java.util.HashMap;
import java.util.Map;

//import java.io.Serializable;

//public class Cart implements Serializable{
public class Cart{	
//    private static final long serialVersionUID = 2155125089108199199L;
    private String cartId;  // ��ٱ��� ID
    private Map<String,CartItem> cartItems; // ��ٱ��� �׸�
    private int grandTotal;  // �Ѿ�

    public Cart() {  
        cartItems = new HashMap<String, CartItem>();
        grandTotal = 0;
    }  

    public Cart(String cartId) {  
        this();
        this.cartId = cartId;
    }  

    public String getCartId() {  
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<String, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public int getGrandTotal() {
        return grandTotal;
    }  

    public void updateGrandTotal() { 
        grandTotal= 0;
        for(CartItem item : cartItems.values()){
            grandTotal = grandTotal + item.getTotalPrice();
        }
    }  

    public void addCartItem(CartItem item) {
        String bookId = item.getBook().getBookId();  // 현재 등록하기 위한 도서 ID 가져오기
        System.out.println("[DEBUG][addCartItem]bookId="+bookId);
        // 도서 ID가 cartItems 객체에 등ㄹ고되어 있는지 여부 확인
        if(cartItems.containsKey(bookId)) {  
            CartItem cartItem = cartItems.get(bookId);  // 등록된 도서 ID에 대한 정보 가져오기
            // 등록된 도서 ID의 개수 추가 저장
            cartItem.setQuantity(cartItem.getQuantity()+item.getQuantity());  
            cartItems.put(bookId, cartItem);   // 등록된 도서 ID에 대한 변경 정보(cartItem) 저장
        } else {
            cartItems.put(bookId, item);  // 도서 ID에 대한 도서 정보(item) 저장  
        }
        updateGrandTotal();   // 총액 갱신
    }
    
    public void removeCartItem(CartItem item) {
        String bookId = item.getBook().getBookId();
        System.out.println("[DEBUG][removeCartItem]bookId="+bookId);        
        cartItems.remove(bookId);  
        updateGrandTotal();  
    }
    
    @Override  
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cart other = (Cart) obj;
        if (cartId == null) {
            if (other.cartId != null)
                return false;
        } else if (!cartId.equals(other.cartId))
            return false;
        return true;
    }  
}