function addToCart(action) {
    alert(action);
    document.addForm.action = action;
    document.addForm.submit();
    alert("도서가 장바구니에 추가되었습니다!");
}

function removeFromCart(action) {
    alert("removeFromCart");
    alert(action);
    document.removeForm.action = action;
    document.removeForm.submit();
    alert("도서가 장바구니에서 삭제되었습니다!");    
//    window.location.reload();    
    

}

function clearCart() {
    document.clearForm.submit();
    alert("모든 도서가 장바구니에서 삭제되었습니다!");    
//    window.location.reload();
}

function deleteConfirm(id){  
    if (confirm("삭제 합니다!!") == true) location.href ="./delete?id="+id;
    else  return;
}