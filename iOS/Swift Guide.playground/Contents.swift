//: Playground - noun: a place where people can play

// 常量
let constant: String = "1"
// constant = "2"  // 试图更改常量会报错

// 变量
var variable = "3"
variable = "4"

// 声明变量类型
let typeString: String = "5"
var noTypeString = "6"  // 自动推断类型

let float: Float = 1.0
let double: Double = Double(float)  // 类型转换

// 字符串插值
let lastName = "Kuixi"
let firstName = "Song"
let newString = "My name is \(lastName + firstName)"
// 数组
var fruits = ["Apple", "Orange", "Banana"]
fruits[0]
fruits.append("Strawberry")
fruits.remove(at: 0)
fruits.count

// 字典
var fruitNumber: [String: Int] = ["Apple" : 1, "Orange" : 2, "Banana" : 3, "Watermelon" : 4]
fruitNumber["Apple"] = 5

// guard
let number = 0
func squareRoot(of number: Int) {
    guard number >= 0 else {
        print("Negative Number")
        return
    }
    // Do more..
}

// if
if number == 0 {
    print("Zero")
} else if number == 1 {
    print("One")
} else {
    print("Bigger than One")
}

// switch
switch number {
case 0:
    print("Zero")
case 1, 2:  // 多个值
    print("One or Two")
case 3...5: // 区间
    print("Three to Five")
default:
    print("Bigger than Six")
}

// for
var forLoop = 0
for i in 0..<3 {
    forLoop += i
}

// while
while forLoop > 1 {
    forLoop -= 1
}

// do-while
repeat {
    forLoop *= 2
} while (forLoop <= 2^10)

// 函数
// func 函数名(参数列表) -> 返回值 {
//     函数体
// }
func myFunction(parameterA: Int, parameterB: Int) -> Int {
    return parameterA + parameterB
}
myFunction(parameterA: 3, parameterB: 5)

// 参数可省略名字，且可以有多个返回值
func anotherFunction(_ omittedParameterName: Int) -> (Int, Int, Int) {
    return (omittedParameterName * 2, omittedParameterName + 2, omittedParameterName - 2)
}
anotherFunction(100)

// 形参和实参名字可不同
func squared(of value: Double) -> Double {
    return value * value
}
squared(of: 20.0)

// 嵌套函数
func addTen(to number: Int) -> Int {
    var temp = number
    func addFive(to number: Int) -> Int {
        return number + 5
    }
    temp = addFive(to: temp)
    temp = addFive(to: temp)
    return temp
}
addTen(to: 10)

// 函数是一等公民
func incrementer() -> ((Int) -> Int) {
    func addOne(to number: Int) -> Int {
        return number + 1
    }
    return addOne
}
var increment = incrementer()
increment(19)

// 闭包
// 就是匿名函数
[1, 5, 3, 2, 4].sorted(by: { (a, b) -> Bool in
    return a < b
})
[1, 5, 3, 2, 4].filter {
    $0 % 2 == 0
}
[1, 5, 3, 2, 4].map {
    $0 * 2
}
// 算 n 的阶乘
func factorial(of n: Int64) -> Int64 {
    return (1...n).reduce(1, *)
}
factorial(of: 20)

let printMyName: ((_ name: String) -> Void) = { name in
    print("I am \(name)")
}
printMyName("KrayC")

// 可选值
var optionalValue: Int? // 默认为 nil
optionalValue = 3
optionalValue! // 强制解包，尽量避免，易导致 Crash
// 可选值绑定
if let realValue = optionalValue {
    print("My value is \(realValue)")
}
// 默认值
print(optionalValue ?? 0)

// 类
class Shape {
    var numberOfSides = 0   // 属性
    var totalInnerAngleSum: Int {   // 计算属性
        get {
            return (numberOfSides - 2) * 180
        }
    }
    
    // 初始化
    init(sides: Int) {
        self.numberOfSides = sides
    }
    
    // 成员方法
    func simpleDescription() -> String {
        return "A shape with \(numberOfSides) sides."
    }
    
    // 类方法
    static func generateShape(numberOfSides: Int) -> Shape {
        return Shape(sides: numberOfSides)
    }
}

let s = Shape(sides: 4)
s.numberOfSides
s.totalInnerAngleSum
s.simpleDescription()
let anotherS = Shape.generateShape(numberOfSides: 3)
anotherS.simpleDescription()

class Square: Shape {
    // 新增成员变量及方法
    var length: Int = 0
    func area() -> Int {
        return length ^ 2
    }
    
    // 便捷构造器
    convenience init(sideLength: Int) {
        self.init(sides: 4)
        self.length = sideLength
    }
    
    // 覆盖成员方法
    override func simpleDescription() -> String {
        return "A rectangle with \(numberOfSides) sides."
    }
    
}
let square = Square(sideLength: 10)
print(square.area())
