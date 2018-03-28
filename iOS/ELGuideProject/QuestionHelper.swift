//
//  QuestionHelper.swift
//  ELGuideProject
//
//  Created by 宋 奎熹 on 2018/3/28.
//  Copyright © 2018年 Kuixi Song. All rights reserved.
//

import Foundation

enum OperationType: Int {
    case add = 1
    case sub = 2
    case mul = 3
    case div = 4
    
    func getString() -> String {
        switch self {
        case .add:
            return "+"
        case .sub:
            return "-"
        case .mul:
            return "*"
        case .div:
            return "/"
        }
    }
}

struct Question {
    var questionString: String
    var rightAnswer: String
    var allResults: [String]
}

class QuestionHelper {
    
    static let shared: QuestionHelper = QuestionHelper()
    
    private init() {
        
    }
    
    func generateQuestion() -> Question {
        func generateDivision(_ a: Double, _ b: Double) -> Double {
            return (b != 0 && a != 0) ? a / b : 0.0
        }
        
        let a = Double(arc4random() % 10) + 1
        let b = Double(arc4random() % 10) + 1
        
        let allResults: [Double] = [a + b, a - b, a * b, generateDivision(a, b)]
        
        let opNum = Int(arc4random() % 4) + 1
        let op = OperationType(rawValue: opNum)!
        
        let rightAnswer: Double = allResults[opNum - 1]
        return Question(questionString: "\(a.toString) \(op.getString()) \(b.toString) = ?",
            rightAnswer: rightAnswer.toString,
            allResults: allResults.shuffle().map { $0.toString })
    }
    
}
