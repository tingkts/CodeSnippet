void revers(Node *head,Node **newhead){
    if(head -> next == NULL){
        *newhead = head;
        return ;
    }
    revers(head -> next , newhead);

    head->next->next = head;
    head->next = NULL;
    return ;
}