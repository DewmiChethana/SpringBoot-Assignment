package com.openarc.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openarc.student.domain.Batch;
import com.openarc.student.service.BatchService;

@RestController
@RequestMapping
public class BatchController {
	
		@Autowired
		BatchService batchService;
		
		@PostMapping("/batch")
		private Batch createBatch(@RequestBody Batch batch) {
			return batchService.saveBatch(batch) ;
		}
		
		@PutMapping(value="/batch/{batchId}/{courseId}")
		private Batch updateBatch(@PathVariable Long batchId,@PathVariable Long courseId,@RequestBody Batch batch) throws Exception {
			return batchService.updateBatch(batchId,courseId, batch);
		}
		
		@DeleteMapping("/batch/{batchId}")
		private boolean deleteBatch(@PathVariable Long batchId) {
			return batchService.deleteBatch(batchId);	
		}
		
		@DeleteMapping(value="/batch/course/{courseId}")
		private boolean deleteByCourse(@PathVariable Long courseId) {
			return batchService.deleteByCourse(courseId);
		}
		
		@GetMapping("/batch/{batchId}")
		private Batch getBatch(@PathVariable Long batchId) {
			return batchService.getBatch(batchId);
		}
		
		@GetMapping(value="/batches")
		private List<Batch> getBatches(){
			return batchService.getAllBatch();
		}
		
		@GetMapping(value = "/batch/course/{courseId}")
		private List<Batch> getBatchByCourse(@PathVariable Long courseId){
			return batchService.getByCourse(courseId);	
		}
	}

