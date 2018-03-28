//
//  ViewController.swift
//  ELGuideProject
//
//  Created by 宋 奎熹 on 2018/3/28.
//  Copyright © 2018年 Kuixi Song. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var questionCountLabel: UILabel!

    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        
        questionCountLabel.text = "已答题数：\(UserDefaults.standard.integer(forKey: "question_count"))"
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }


}

