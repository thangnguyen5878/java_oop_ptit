# Bài tập Java OOP - PTIT
Bài tập được làm trên phần mềm IntelliJ IDEA
## Bài tập hướng đối tượng cơ bản
### Rectangle
[Source code](https://github.com/Thang58787/java_oop_ptit/tree/main/rectangle/src) 

Viết một chương trình khai báo một lớp Rectangle có 2 thuộc tính là chiều dài và chiều rộng và có các phương thức sau: 
- Hàm tạo không tham số.
- Hàm tạo có 2 tham số.
- Get/set cho các thuộc tính.
- Phương thức tính diện tích hình chữ nhật.
- Phương thức tính chu vi hình chữ nhật.
### QuadraticEquation
[Source code](https://github.com/Thang58787/java_oop_ptit/tree/main/QuadraticEquation/src) 

Viết chương trình khai báo một lớp Phương trình bậc 2 với các thuộc tính là a, b, c với các phương thức sau: 
- Hàm tạo không tham số.
- Hàm tạo có 3 tham số.
- Get/set cho 3 thuộc tính.
- Phương thức tính delta.
- Phương thức tính nghiệm phương trình.
### Animal
[Source code](https://github.com/Thang58787/java_oop_ptit/tree/main/Animal/src)

Viết chương trình khai báo một lớp trừu tượng là Animal có phương thức eat() và makeSound().
Xây dựng các lớp Cat và Bird kế thừa lớp Animal trong đó: 
- Lớp Cat có phương thức run()
- Lớp Bird có phương thức fly()
### QLCB (Quản lý cán bộ)
[Source code](https://github.com/Thang58787/java_oop_ptit/tree/main/QLCB/src) 

Một đơn vị sản xuất gồm có các cán bộ là công nhân, kỹ sư, nhân viên. Mỗi cán bộ cần quản lý các dữ liệu: Họ tên, tuổi, giới tính(name, nữ, khác), địa chỉ.
- Cấp công nhân sẽ có thêm các thuộc tính riêng: Bậc (1 đến 10).
- Cấp kỹ sư có thuộc tính riêng: Ngành đào tạo.
- Các nhân viên có thuộc tính riêng: công việc.

Yêu cầu 1: Xây dựng các lớp *CongNhan*, *KySu*, *NhanVien* kế thừa từ lớp *CanBo*.
Yêu cầu 2: Xây dựng lớp *QLCB* (quản lý cán bộ) cài đặt các phương thức thực hiện các chức năng sau:
- Thêm mới cán bộ.
- Tìm kiếm theo họ tên.
- Hiện thị thông tin về danh sách các cán bộ.
- Thoát khỏi chương trình.
### Handy Expense
[Source code](https://github.com/thangnguyen5878/java_oop_ptit/tree/main/HandyExpense/src)

Write a program to manage expenses, named Handy expense.

Display the menu:

Handy Expense

1. Add an expense
2. Display all expenses
3. Delete an expense
4. Save
5. Quit

Your choice:

1. If user chooses 1, let him/her add expenses. Each expense include ID(int), date(String), amount(double), content(String). Whereas, expense ID is increase automatically(i.e new expense has ID equal to last expense ID + 1), the first expense has ID: 1. The date field is entered in “dd-MMM-yyyy” format.

2. If user chooses 2, the program needs to display list of expenses that were entered in 1st step. The list should be shown as the format below(the following data is just dummy):

| ID  | Date        | Amount | Content     |
| --- | ----------- | ------ | ----------- |
| 1   | 11-Apr-2009 | 100    | Tuition fee |
| 2   | 20-Apr-2009 | 250    | Rent house  |
| 3   | 30-Apr-2009 | 200    | Food        |

Total: 550

3. If user chooses 3, the program requires him/her enter the ID for delete, if no expense has ID as given, display a message: “No expense found”.
4. If user chooses 4, save the data.
5. If user chooses 5, quit the program.

The data is saved in Expense.txt in the following format:

```
5-May-2023, 40.0, flowers
5-May-2034, 20.0, books
6-May-2023, 50.0, fuel
6-Mar-2023, 10.0, Drinks
8-Mar-2023, 40.0, pens
```

