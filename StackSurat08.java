public class StackSurat08 {
    Surat08[] stack;
    int top;
    int size;

    public StackSurat08(int size) {
        this.size = size;
        stack = new Surat08[size];
        top = -1;
    }

    // method isFull
    public boolean isFull() {
        return top == size - 1;
    }

    // method isEmpty
    public boolean isEmpty() {
        return top == -1;
    }

    // method push 
    public void push(Surat08 surat) {
        if (!isFull()) {
            top++;
            stack[top] = surat;
        } else {
            System.out.println("Stack penuh! Tidak bisa menerima surat lagi.");
        }
    }

    // method pop 
    public Surat08 pop() {
        if (!isEmpty()) {
            Surat08 s = stack[top];
            top--;
            return s;
        } else {
            System.out.println("Stack kosong! Tidak ada surat untuk diproses.");
            return null;
        }
    }

    // method peek 
    public Surat08 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong! Tidak ada surat.");
            return null;
        }
    }

    // method cariSurat 
    public Surat08 cariSurat(String namaMahasiswa) {
        for (int i = top; i >= 0; i--) {
            if (stack[i].namaMahasiswa.equalsIgnoreCase(namaMahasiswa)) {
                return stack[i];
            }
        }
        return null;
    }
}