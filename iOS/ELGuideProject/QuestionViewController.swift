//
//  QuestionViewController.swift
//  ELGuideProject
//
//  Created by 宋 奎熹 on 2018/3/28.
//  Copyright © 2018年 Kuixi Song. All rights reserved.
//

import UIKit

class QuestionViewController: UIViewController {
    
    @IBOutlet weak var questionLabel: UILabel!
    @IBOutlet var choiceButtons: [UIButton]!
    @IBOutlet weak var nextBarButton: UIBarButtonItem!
    
    private var question: Question?
    
    lazy var currentQuestionCount: Int = {
        return UserDefaults.standard.integer(forKey: "question_count")
    }()

    override func viewDidLoad() {
        super.viewDidLoad()

        generateQuestion(nil)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewDidDisappear(animated)
        
        saveQuestionCount()
    }
    
    @IBAction func generateQuestion(_ sender: Any?) {
        question = QuestionHelper.shared.generateQuestion()
        questionLabel.text = question!.questionString
        for i in 0..<4 {
            choiceButtons[i].setTitleColor(.blue, for: .normal)
            choiceButtons[i].backgroundColor = .clear
            choiceButtons[i].setTitle(question!.allResults[i], for: .normal)
        }
    }
    
    @IBAction func chooseAnswer(_ sender: UIButton) {
        if let realQuestion = question {
            if realQuestion.rightAnswer == realQuestion.allResults[sender.tag] {
                sender.setTitleColor(.white, for: .normal)
                sender.backgroundColor = .blue
            } else {
                sender.setTitleColor(.white, for: .normal)
                sender.backgroundColor = .red
                
                let rightButton = choiceButtons.filter { $0.title(for: .normal)! == realQuestion.rightAnswer }.first!
                rightButton.setTitleColor(.white, for: .normal)
                rightButton.backgroundColor = .blue
            }
            
            currentQuestionCount += 1
        }
    }
    
    private func saveQuestionCount() {
        UserDefaults.standard.set(currentQuestionCount, forKey: "question_count")
    }
    
}
