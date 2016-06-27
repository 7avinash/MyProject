from django.db import models
from django.contrib.auth.models import User

# Create your models here.

class Institute(models.Model):
	name = models.CharField(max_length=120)

	def __str__(self):
		return self.name


class UserDetail(models.Model):
	user = models.OneToOneField(User)
	institute = models.ForeignKey(Institute)
	name = models.CharField(max_length=120)


	###Fields to add
		##Date of Birth
		##Phone Number
		##Type of user (i.e Student or Professor or Startup)

	def __str__(self):
		return self.user.username

class UserGroup(models.Model):
	name = models.CharField(max_length=120)
	owner = models.ForeignKey(User, related_name='owner')
	members = models.ManyToManyField(User, related_name='members', blank=True)

	def __str__(self):
		return self.name
