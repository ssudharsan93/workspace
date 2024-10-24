from crewai import Agent, Crew, Process, Task
from crewai.project import CrewBase, agent, crew, task

# Uncomment the following line to use an example of a custom tool
# from crew_test.tools.custom_tool import MyCustomTool

# Check our tools documentations for more information on how to use them
# from crewai_tools import SerperDevTool

@CrewBase
class VacationPlanningCrew():
	"""Vacation Planning Crew"""

	@agent
	def vacation_researcher(self) -> Agent:
		return Agent(
			config=self.agents_config['vacation_researcher'],
			# tools=[MyCustomTool()], # Example of custom tool, loaded on the beginning of file
			verbose=True,
			allow_delegation=False
		)

	@agent
	def vacation_planning_specialist(self) -> Agent:
		return Agent(
			config=self.agents_config['vacation_planning_specialist'],
			verbose=True,
			allow_delegation=False
		)
	
	@agent
	def vacation_day_breakdown_planner(self) -> Agent:
		return Agent(
			config=self.agents_config['vacation_day_breakdown_planner'],
			verbose=True,
			allow_delegation=False
		)

	@task
	def vacation_research_task(self) -> Task:
		return Task(
			config=self.tasks_config['vacation_research_task'],
		)

	@task
	def vacation_planning_task(self) -> Task:
		return Task(
			config=self.tasks_config['vacation_planning_task'],
		)
	
	@task
	def day_planning_task(self) -> Task:
		return Task(
			config=self.tasks_config['vacation_day_breakdown_task'],
			output_file='report.md'
		)

	@crew
	def crew(self) -> Crew:
		"""Creates the CrewTest crew"""
		return Crew(
			agents=self.agents, # Automatically created by the @agent decorator
			tasks=self.tasks, # Automatically created by the @task decorator
			process=Process.sequential,
			verbose=True,
			# process=Process.hierarchical, # In case you wanna use that instead https://docs.crewai.com/how-to/Hierarchical/
		)