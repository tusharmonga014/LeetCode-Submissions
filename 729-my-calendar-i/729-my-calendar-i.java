class MyCalendar {
    
    private ArrayList<Integer[]> slots;

    public MyCalendar() {
        slots = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(Integer[] slot : slots) {
            if((start >= slot[0] && start < slot[1]) || (end <= slot[1] && end > slot[0]) || (start <= slot[0] && end >= slot[1]))
                return false;
        }
        Integer[] newSlot = new Integer[2];
        newSlot[0] = start;
        newSlot[1] = end;
        slots.add(newSlot);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */