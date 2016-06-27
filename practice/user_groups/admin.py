from django.contrib import admin
from .models import UserGroup, UserDetail, Institute

# Register your models here.
admin.site.register(UserGroup)
admin.site.register(UserDetail)
admin.site.register(Institute)
